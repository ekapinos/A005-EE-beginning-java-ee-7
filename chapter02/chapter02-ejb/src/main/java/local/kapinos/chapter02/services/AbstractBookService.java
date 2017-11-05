package local.kapinos.chapter02.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import modelocal.kapinos.chapter02.model.Book;

public abstract class AbstractBookService {

	@Inject
	protected Logger logger;

	private NumberGenerator numberGenerator;

	public AbstractBookService(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	//@ExcludeClassInterceptors
	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setIsbn(numberGenerator.generateNumber());
		return book;
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