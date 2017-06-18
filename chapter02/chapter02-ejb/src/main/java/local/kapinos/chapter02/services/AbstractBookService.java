package local.kapinos.chapter02.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import modelocal.kapinos.chapter02.model.Book;

public abstract class AbstractBookService {

	@Inject
	protected Logger logger;

	private NumberGenerator numberGenerator;

	AbstractBookService(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setIsbn(numberGenerator.generateNumber());
		return book;
	}

	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		logger.log(Level.WARNING, "@AroundInvoke-entering-" + ic.getMethod().getName());
		//logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			logger.log(Level.WARNING, "@AroundInvoke-exiting-" + ic.getMethod().getName());
			//logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
		}
	}

	@PostConstruct
	public void postConstruct() {
		logger.log(Level.WARNING, "@PostConstruct " + getClass().getSimpleName());
	}

	@PreDestroy
	public void preDestroy() {
		logger.log(Level.WARNING, "@PreDestroy " + getClass().getSimpleName());
	}

}