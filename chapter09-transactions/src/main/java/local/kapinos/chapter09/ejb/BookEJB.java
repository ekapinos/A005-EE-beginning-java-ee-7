package local.kapinos.chapter09.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionManager;
import javax.transaction.TransactionSynchronizationRegistry;

import local.kapinos.chapter09.model.Book;

@Stateless
//@TransactionAttribute(TransactionAttributeType.SUPPORTS) //Caused by: javax.persistence.TransactionRequiredException
//@TransactionAttribute(TransactionAttributeType.NEVER) //same
public class BookEJB {

	Logger logger = Logger.getLogger(getClass().getName());

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private SessionContext ctx;
	
	//https://docs.oracle.com/cd/E19159-01/819-3672/gaxit/index.html
	@Resource(lookup="java:appserver/TransactionManager")
	TransactionManager txm;
	@Resource(lookup="java:appserver/TransactionSynchronizationRegistry")
	TransactionSynchronizationRegistry txr;

	public Book createBook(Book book, boolean rollback) {
		logTxStatus();
		em.persist(book);
		
		if (rollback)
		{
			ctx.setRollbackOnly();
		}
		return book;
	}

	public List<Book> findBooks() {
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
