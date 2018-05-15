package local.kapinos.chapter08.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import local.kapinos.chapter08.ejb.BookEJBRemote;
import local.kapinos.chapter08.model.Book;

public class Main {

	//@EJB
	//static BookEJBRemote bookJB; // Works only with ACC, via ..\glassfish\bin\appclient
	
	public static void main(String[] args) throws NamingException {

		// Looks up the EJB
		Context ctx = new InitialContext(); // Works only with "gf-client" maven artifact
		BookEJBRemote bookEJB = (BookEJBRemote) ctx
				.lookup("java:global/chapter08-callbacks-timerservice-authorization/BookEJB!local.kapinos.chapter08.ejb.BookEJBRemote");
		// Gets and displays all the books from the database
		List<Book> books = bookEJB.findBooks();
		for (Book aBook : books) {
			System.out.println(aBook);
		}
		// Creates an instance of book
		Book book = new Book("H2G2", 12.5F, "Scifi book", "1-24561-799-0", 354, false);
		book = bookEJB.createBook(book);
		System.out.println("Book created : " + book);
		book.setTitle("H2G2");
		book = bookEJB.updateBook(book);
		System.out.println("Book updated : " + book);
		bookEJB.deleteBook(book);
		System.out.println("Book deleted");
	}
}
