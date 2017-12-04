package local.kapinos.chapter04;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		
		em.persist(new Book("Title", 12.0f, "Description", "isbn", 10, false));
		
		logger.warning("End");
	}

}
