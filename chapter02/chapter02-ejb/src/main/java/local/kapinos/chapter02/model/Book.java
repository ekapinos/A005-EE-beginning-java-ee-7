package local.kapinos.chapter02.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Book {
	String isbn;
	String title;
	Float price;
	String description;

	public Book(String title, Float price, String description) {
		this.title = title;
		this.price = price;
		this.description = description;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
