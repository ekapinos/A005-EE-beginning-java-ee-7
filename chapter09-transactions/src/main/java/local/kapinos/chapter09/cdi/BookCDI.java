package local.kapinos.chapter09.cdi;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;

import local.kapinos.chapter09.model.Book;

@RequestScoped
public class BookCDI {

	Logger logger = Logger.getLogger(getClass().getName());

	@PersistenceContext
	private EntityManager em;

	@Resource(lookup="java:appserver/TransactionSynchronizationRegistry")
	TransactionSynchronizationRegistry txr;

	@Transactional
	public Book createBook(Book book, boolean rollback) { //TransactionRequiredExceptionif not @Transactional
		logTxStatus();
		em.persist(book);
		if (rollback) 
		{
			throw new RuntimeException("User rollback"); // exception is logged by Server
		}
		return book;
	}

	public List<Book> findBooks() { // OK without @Transactional. transactionKey=null here
		logTxStatus();
		TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
		return query.getResultList();
	}
	
	private void logTxStatus()
	{
		logger.info(this + 
				", isJoinedToTransaction="+ em.isJoinedToTransaction() + 
				", transactionKey=" + txr.getTransactionKey());		
	}
}
