package local.kapinos.chapter15.console;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import local.kapinos.chapter15.model.Book;

public class BookRestClient {
	public static void main(String[] args) {
		URI uri = UriBuilder.fromUri("http://localhost/chapter15-RESTful-web-services/rs/book").port(8080).build();

		Client client = ClientBuilder.newClient();
		
		Response response = client.target(uri).request().post(Entity.entity(null, MediaType.APPLICATION_XML));
		System.out.println(response);
		
		response = client.target(uri).path("unknownID").request().get();
		System.out.println(response);
		
		Book book = new Book("H2G2", 12.5F, "Science book", "1-84023-742-2", 354, false);

		// POSTs a Book
		response = client.target(uri).request().post(Entity.entity(book, MediaType.APPLICATION_XML));
		System.out.println(response);
		
		URI bookURI = response.getLocation();
		// With the location, GETs the Book
		response = client.target(bookURI).request().get();
		book = response.readEntity(Book.class);
		System.out.println(response);

		String bookId = bookURI.toString().split("/")[6];
		response = client.target(uri).path(bookId).request().delete();
		System.out.println(response);
	}
}
