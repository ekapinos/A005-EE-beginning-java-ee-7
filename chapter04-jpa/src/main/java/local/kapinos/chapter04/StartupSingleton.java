package local.kapinos.chapter04;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import local.kapinos.chapter04.model.Book;

@Startup	
@Singleton
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	public void postConstruct() {
		logger.warning("Start");
		
		// See log for SQL queries
		em.persist(new Book("Title", 12.0f, "Description", "isbn", 10, false));
		em.persist(new Book("H2G2", 13.0f, "Description H2G2", "isbn-H2G2", 11, true));
		
		List<Book> books = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
		logger.info("Named Query book: " + books);
		
		try{
		  em.persist(new Book("Title", 12.0f, "too short", "isbn", 10, false));
		}catch(ConstraintViolationException e){
			logger.info("Expected fail: " + e.getConstraintViolations());
		}

		logger.warning("End");
	}

}
