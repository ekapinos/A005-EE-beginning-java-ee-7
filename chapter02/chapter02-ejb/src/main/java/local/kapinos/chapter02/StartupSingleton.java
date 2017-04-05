package local.kapinos.chapter02;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Inject
	AbstractBookService bookService;
	
	@PostConstruct
	public void postConstruct(){
		logger.log(Level.WARNING, "postConstruct EJB");
		Book book = bookService.createBook("title", 10.0f, "descr");
		logger.log(Level.WARNING, "Book is created " + book);
	}
	
	@PreDestroy
	public void postDestroy(){
		logger.log(Level.WARNING, "postDestroy EJB");
	}	
}
