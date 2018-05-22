package local.kapinos.chapter09.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.kapinos.chapter09.cdi.BookCDI;
import local.kapinos.chapter09.model.Book;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN) // no transaction
public class StartupSingleton {

	Logger logger = Logger.getLogger(getClass().getName());

	@PersistenceContext
	private EntityManager em;

	@Inject
	private BookEJB bookEJB;
	
	@Inject
	private BookCDI bookCDI;

	@PostConstruct
	public void postConstruct() {
		logger.info(this + " isJoinedToTransaction="+ em.isJoinedToTransaction());
		Book h2g2 = new Book("Beginning Java EE 7", 35F, "Great book", "1-8763-9125-7", 605, true);
		Book lord = new Book("The Lord of the Rings", 50.4f, "SciFi ", "1-84023-742-2", 1216, true);
		
		//em.persist(lord); //Caused by: javax.persistence.TransactionRequiredException
		
		// 3 transactions due to BMT
		bookEJB.createBook(h2g2, false);
		bookEJB.createBook(lord, true);
		List<Book> books = bookEJB.findBooks(); // if change this bean to CMT, than here TransactionRolledbackLocalException: Client's transaction aborted
		
		
		logger.info("EJB findBooks=" + books.toString());//Book #1 
		
		Book thirdBook = new Book("Third book", 50.5f, "SciFi ", "1-84023-742-3", 1217, true);
		Book forthBook = new Book("Forth book", 50.6f, "SciFi ", "1-84023-742-4", 1218, true);
		bookCDI.createBook(thirdBook, false);
		try{
			bookCDI.createBook(forthBook, true);
		}
		catch (RuntimeException e)
		{
			logger.info(e.getMessage());
		}
		books = bookCDI.findBooks();
		logger.info("CDI findBooks=" + books.toString()); //Book #1 and #3
	}

}