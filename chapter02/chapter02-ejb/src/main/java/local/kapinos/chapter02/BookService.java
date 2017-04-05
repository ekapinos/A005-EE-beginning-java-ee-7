package local.kapinos.chapter02;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class BookService {
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Inject
	private NumberGenerator numberGenerator;

	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setIsbn(numberGenerator.generateNumber());
		return book;
	}
	
	@PostConstruct
	public void postConstruct(){
		logger.log(Level.WARNING, "postConstruct BookService");
	}
}