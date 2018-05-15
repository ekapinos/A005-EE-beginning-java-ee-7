package local.kapinos.chapter08.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;

import local.kapinos.chapter08.model.Book;

@Remote
public interface BookEJBRemote {
	List<Book> findBooks();

	@NotNull Book createBook(@NotNull Book book);

	void deleteBook(@NotNull Book book);

	@NotNull Book updateBook(@NotNull Book book);
}
