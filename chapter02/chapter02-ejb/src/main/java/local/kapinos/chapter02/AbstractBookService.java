package local.kapinos.chapter02;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public abstract class AbstractBookService {

	private final Logger logger = Logger.getLogger(getClass().getName());

	private NumberGenerator numberGenerator;

	AbstractBookService(NumberGenerator numberGenerator){
		this.numberGenerator = numberGenerator;
	}
	
	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setIsbn(numberGenerator.generateNumber());
		return book;
	}

	@PostConstruct
	public void postConstruct() {
		logger.log(Level.WARNING, "postConstruct " + getClass().getSimpleName());
	}

	@PreDestroy
	public void postDestroy() {
		logger.log(Level.WARNING, "postDestroy " + getClass().getSimpleName());
	}

}