package local.kapinos.chapter05.model07.inheritance;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("B")
public class m07_Book  extends m07_Item {
	private String isbn;
	private String publisher;
	private Integer nbOfPage;
	private Boolean illustrations;
	// Constructors, getters, setters
	public m07_Book() {
	}
	public m07_Book(String title, Float price, String description, String isbn, String publisher, Integer nbOfPage, Boolean illustrations) {
		super(title, price, description);
		this.isbn = isbn;
		this.publisher = publisher;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getNbOfPage() {
		return nbOfPage;
	}
	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}
	public Boolean getIllustrations() {
		return illustrations;
	}
	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}
	
}
