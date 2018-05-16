package local.kapinos.chapter08.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import local.kapinos.chapter08.model.Book;

@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

	@Inject
	private EntityManager em;

	public List<Book> findBooks() {
		TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
		return query.getResultList();
	}

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	public Book updateBook(Book book) {
		return em.merge(book);
	}

	public void deleteBook(Book book) {
		em.remove(em.merge(book));
	}
}
