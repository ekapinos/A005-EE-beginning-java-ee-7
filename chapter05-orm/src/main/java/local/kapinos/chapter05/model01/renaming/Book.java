package local.kapinos.chapter05.model01.renaming;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_book")
@Access(AccessType.FIELD)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // means TABLE for EclipseLink
	public Long id;
	public String title;
	public Float price;
	public String description;
	public String isbn;
	public Integer nbOfPage;
	public Boolean illustrations;

	Book() {
	}

	public Book(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
	}
	
	public void setPrice(Float price)
	{
		this.price = price;
	}

	// Constructors, getters, setters
}
