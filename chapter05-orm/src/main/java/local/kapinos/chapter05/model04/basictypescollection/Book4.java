package local.kapinos.chapter05.model04.basictypescollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

@Entity
public class Book4 {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private Float price;
	private String description;
	private String isbn;
	private Integer nbOfPage;
	private Boolean illustrations;
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "Book4_Tags")
	@Column(name = "Value")
	private List<String> tags = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="book4_track")
	@MapKeyColumn (name = "position")
	@Column(name = "title")
	private Map<Integer, String> tracks = new HashMap<>();

	// Constructors, getters, setters
	public Book4() {
	}

	public Book4(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations,
			List<String> tags, Map<Integer, String> tracks) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
		this.tags = tags;
		this.tracks = tracks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
