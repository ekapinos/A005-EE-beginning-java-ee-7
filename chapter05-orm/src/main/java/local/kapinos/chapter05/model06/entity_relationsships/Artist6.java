package local.kapinos.chapter05.model06.entity_relationsships;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;

@Entity
public class Artist6 {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToMany
	@JoinTable(name = "jnd_art_cd", 
	           joinColumns = @JoinColumn(name = "artist_fk"), 
	           inverseJoinColumns = @JoinColumn(name = "cd_fk"))
	@OrderBy("price DESC")
	private List<CD6> appearsOnCDs;
		
	@ElementCollection(fetch = FetchType.EAGER)
	@OrderColumn(name = "my_index")
	private List<String> orderedStrings;

	// Constructors, getters, setters

	public Artist6(){
	}
	public Artist6(String firstName, String lastName, List<CD6> appearsOnCDs, List<String> orderedStrings) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.appearsOnCDs = appearsOnCDs;
		this.orderedStrings = orderedStrings;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<CD6> getAppearsOnCDs() {
		return appearsOnCDs;
	}
	public void setAppearsOnCDs(List<CD6> appearsOnCDs) {
		this.appearsOnCDs = appearsOnCDs;
	}
	public List<String> getOrderedStrings() {
		return orderedStrings;
	}
	public void setOrderedStrings(List<String> orderedStrings) {
		this.orderedStrings = orderedStrings;
	}
}
