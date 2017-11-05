package local.kapinos.chapter02;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import local.kapinos.chapter02.decorator.PriceChecker;
import local.kapinos.chapter02.model.Book;
import local.kapinos.chapter02.qualifier.RandomDouble;
import local.kapinos.chapter02.services.AbstractBookService;

@Startup
@Singleton
public class StartupSingleton {

	@Inject
	Logger logger;
	
	@Inject
	AbstractBookService bookService;
	
	@Inject
	PriceChecker priceChecker;
	
	@Inject
	@RandomDouble
	double randomDouble1, randomDouble2;
	
	@PostConstruct
	public void postConstruct(){
		logger.log(Level.WARNING, "@PostConstruct " + this.getClass().getSimpleName());
		
		Book book = bookService.createBook("title", 10.0f, "descr");
		
		priceChecker.checkPrice(book);
		
		logger.log(Level.WARNING, "Book is created " + book);		
		logger.log(Level.WARNING, "");
		logger.log(Level.WARNING, "randomDouble1 = " + randomDouble1);
		logger.log(Level.WARNING, "randomDouble2 = " + randomDouble2);
	}
	
	@PreDestroy
	public void postDestroy(){
		logger.log(Level.WARNING, "@PreDestroy " + this.getClass().getSimpleName());
	}	
}
