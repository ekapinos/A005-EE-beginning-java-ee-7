package local.kapinos.chapter05.model06.entity_relationsships;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CD6 {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private Float price;
	private String description;
	@ManyToMany(mappedBy = "appearsOnCDs")
	private List<Artist6> createdByArtists;
	// Constructors, getters, setters
	
	public CD6(){
	}
	public CD6(String title, Float price, String description, List<Artist6> createdByArtists) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.createdByArtists = createdByArtists;
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
	public List<Artist6> getCreatedByArtists() {
		return createdByArtists;
	}
	public void setCreatedByArtists(List<Artist6> createdByArtists) {
		this.createdByArtists = createdByArtists;
	}
	
	
}
