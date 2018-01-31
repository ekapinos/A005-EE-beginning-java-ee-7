package local.kapinos.chapter05;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.kapinos.chapter05.model01.Book;

@Startup	
@Singleton
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	public void postConstruct() {
		logger.warning("Start (see log for SQL queries)");
		logger.info("em.isJoinedToTransaction() = " + em.isJoinedToTransaction()); // true. We in EJB bean with JTA transaction
		
		em.persist(new Book("Title", 12.0f, "Description", "isbn", 10, false));
		
		Book book = new Book("Title1", 13.0f, "Description1", "isbn1", 11, false);
		logger.info("em.contains(book) = " + em.contains(book)); // false
		em.persist(book);
		logger.info("em.contains(book) = " + em.contains(book)); // true
        em.flush(); // 2 x INSERT
        
		book.title += "_upd"; 
		book.price = 12f;
		em.flush(); // UPDATE via property does not work for EclipseLink JPA provider (by default). see http://www.eclipse.org/eclipselink/documentation/2.5/jpa/extensions/a_changetracking.htm
		            // but should work for Hiberhate https://docs.jboss.org/hibernate/orm/4.3/javadocs/org/hibernate/CustomEntityDirtinessStrategy.html
		
		em.clear();
		Book book_upd = em.find(Book.class, 2L); // SELECT		
		em.merge(book);
		logger.info("book_upd==book -> " + (book_upd == book)); // false -> because of em.clear()
		logger.info("book_upd.price==book.price -> " + (book_upd.price == book.price)); // true, em.merge(book);		
		em.flush();  // UPDATE

		book_upd.setPrice(13f);
		em.flush();  // UPDATE via setter works in EclipseLink
			
		logger.warning("End");
	}

}
