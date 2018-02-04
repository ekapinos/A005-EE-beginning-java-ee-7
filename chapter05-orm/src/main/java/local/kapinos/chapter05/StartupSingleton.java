package local.kapinos.chapter05;

import java.util.Arrays;
import java.util.HashMap;
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

@Startup	
@Singleton
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	public void postConstruct() {
		logger.warning("Start (see log for SQL queries)");
		
		//runModel01();
		//runModel02();
		//runModel03();
		runModel04();
			
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
}
