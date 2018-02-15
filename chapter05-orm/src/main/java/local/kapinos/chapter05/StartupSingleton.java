package local.kapinos.chapter05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.kapinos.chapter05.model01.renaming.Book;
import local.kapinos.chapter05.model02.compositeid.News;
import local.kapinos.chapter05.model02.compositeid.NewsId;
import local.kapinos.chapter05.model02.compositeid.NewsIdV2;
import local.kapinos.chapter05.model02.compositeid.NewsV2;
import local.kapinos.chapter05.model03.enums_accesstype.CreditCard;
import local.kapinos.chapter05.model03.enums_accesstype.CreditCardType;
import local.kapinos.chapter05.model03.enums_accesstype.Track;
import local.kapinos.chapter05.model04.basictypescollection.Book4;
import local.kapinos.chapter05.model06.entity_relationsships.Address6;
import local.kapinos.chapter05.model06.entity_relationsships.Artist6;
import local.kapinos.chapter05.model06.entity_relationsships.CD6;
import local.kapinos.chapter05.model06.entity_relationsships.Customer6;
import local.kapinos.chapter05.model06.entity_relationsships.Order6;
import local.kapinos.chapter05.model06.entity_relationsships.OrderLine6;
import local.kapinos.chapter05.model07.inheritance.m07_CD;

@Startup	
@Singleton
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	public void postConstruct() {
		logger.warning("Start (see log for SQL queries)");
		
		/* *-/
		runModel01();
		runModel02();
		runModel03();
		runModel04();
		runModel06();
		*/
		runModel07();
			
		logger.warning("End");
	}
	
	protected void runModel01()
	{
		logger.info("model 01");
		
		logger.info("em.isJoinedToTransaction() = " + em.isJoinedToTransaction()); // true. We are in EJB bean with JTA transaction
		
		em.persist(new Book("Title", 12.0f, "Description", "isbn", 10, false));
		
		Book book = new Book("Title1", 13.0f, "Description1", "isbn1", 11, false);
		logger.info("em.contains(book) = " + em.contains(book)); // false
		em.persist(book);
		//logger.info("em.contains(book) = " + em.contains(book)); // true
        em.flush(); // 2 x INSERT
        
		book.title += "_upd"; 
		book.price = 12f;
		em.flush(); // UPDATE via property does not work for EclipseLink JPA provider (by default). see http://www.eclipse.org/eclipselink/documentation/2.5/jpa/extensions/a_changetracking.htm
		            // but should work for Hibernate https://docs.jboss.org/hibernate/orm/4.3/javadocs/org/hibernate/CustomEntityDirtinessStrategy.html
		
		em.clear();
		Book book_upd = em.find(Book.class, 2L); // SELECT		
		em.merge(book);
		logger.info("book_upd==book -> " + (book_upd == book)); // false -> because of em.clear()
		logger.info("book_upd.price==book.price -> " + (book_upd.price == book.price)); // true, em.merge(book);		
		em.flush();  // UPDATE

		book_upd.setPrice(13f);
		em.flush();  // UPDATE via setter works in EclipseLink
	}

	protected void runModel02()
	{
		logger.info("model 02");
		
		em.persist(new News(new NewsId("title", "language"), "test_content"));
		News news = em.find(News.class, new NewsId("title", "language"));
		logger.info("news.getContent() = " + news.getContent());
		
		em.persist(new NewsV2("title", "language", "v2_test_content"));
		NewsV2 v2News = em.find(NewsV2.class, new NewsIdV2("title", "language"));
		logger.info("v2News.getContent() = " + v2News.getContent());
	}

	protected void runModel03()
	{
		logger.info("model 03");
		
		em.persist(new Track("title", 5.05f, new byte[]{0,1,2,3}, "description"));		
		em.persist(new CreditCard("***-****-****-1234", "04/18", 123, CreditCardType.AMERICAN_EXPRESS));
	}
	protected void runModel04()
	{
		logger.info("model 04");
		
		Map<Integer, String> tracks = new HashMap<>();
		tracks.put(1, "Track A");
		tracks.put(2, "Track B");
		em.persist(new Book4("title", 10.1f, "description", "isbn", 200, true, Arrays.asList("TagA", "tagB"), tracks));
	}	
	protected void runModel06()
	{
		logger.info("model 06");
		
		Address6 address = new Address6("street1", "street2", "city", "state", "zipcode", "country");

		Customer6 customer = new Customer6("firstName", "lastName", "email", "phoneNumber", address);
		em.persist(customer);
		//em.flush(); //No : Caused by: java.lang.IllegalStateException: During synchronization a new object was found through a relationship that was not marked cascade PERSIST
		em.persist(address);
		
		// You must maintain both sides of bi-directional relationships in JPA (and Java in general).
		logger.info("address.getCustomer()=" + address.getCustomer()); // null		
		em.flush();
		logger.info("address.getCustomer()=" + address.getCustomer()); // null
		em.refresh(address);
		logger.info("address.getCustomer()=" + address.getCustomer()); // not null

		em.flush();
		
		//@OneToMany with CascadeType.ALL
		em.persist(new Order6(new Date(), 
				              Arrays.asList(new OrderLine6("item1", 12.6, 4), new OrderLine6("item2", 12.8, 6))));
		em.flush();
		
		//@ManyToMany
		List<Artist6> createdByArtists = new ArrayList<>();
		CD6 cd1 = new CD6("title1", 12.3f, "description1", createdByArtists);
		CD6 cd2 = new CD6("title2", 23.4f, "description2", createdByArtists);
		
		List<CD6> appearsOnCDs = new ArrayList<>(); 
		Artist6 artist1 = new Artist6("firstName", "lastName", appearsOnCDs, null);
		Artist6 artist2 = new Artist6("firstName", "lastName", appearsOnCDs, null);
		
		// CD6 does not own relationship, we can load 'appearsOnCDs' only 
		// But CD6 instances are in inconsistent state 
		
		//createdByArtists.add(artist1);
		//createdByArtists.add(artist2);
		appearsOnCDs.add(cd1);
		appearsOnCDs.add(cd2);
		
		em.persist(cd1);
		em.persist(cd2);
		em.persist(artist1);
		em.persist(artist2);
		
		em.flush();
		em.clear();
		
		//@Orderby ("price desc")
		Artist6 artict2_1 = em.find(Artist6.class, artist2.getId());
		logger.info("artict2_1=" + artict2_1.getAppearsOnCDs().get(0).getPrice()); // -> 23.4f
		
		artict2_1.setOrderedStrings(Arrays.asList("1.1", "1.9", "1.10"));
		em.persist(artict2_1);
	}
	
	protected void runModel07()
	{
		logger.info("model 07");
		
		// m07_CD inherit mapping information from @MappedSuperclass
		em.persist(new m07_CD("title", 12.0f, "description", "musicCompany", 2, 30f, "genre"));
	}
}
