package local.kapinos.chapter03.event;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import local.kapinos.chapter03.model.Book;

public class InventoryService {
	@Inject
	private Logger logger;
	List<Book> inventory = new ArrayList<>();

	public void addBook(@Observes @AddedBook Book book) {
		logger.warning("@Observes: Adding book " + book.getTitle() + " to inventory");
		inventory.add(book);
	}
	
	public void removeBook(@Observes @RemovedBook Book book) {
		logger.warning("@Observes: Removing book " + book.getTitle() + " to inventory");
		inventory.add(book);
	}
}
