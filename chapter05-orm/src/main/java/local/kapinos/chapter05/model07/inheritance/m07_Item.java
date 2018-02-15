package local.kapinos.chapter05.model07.inheritance;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn (name="disc", discriminatorType = DiscriminatorType.CHAR) // Anyway EclipceLink generated VARCHAR(31)
//@DiscriminatorValue("I")
public class m07_Item {
	@Id
	@GeneratedValue
	protected Long id;
	protected String title;
	protected Float price;
	protected String description;

	// Constructors, getters, setters
	
	public m07_Item() {
	}
	public m07_Item(String title, Float price, String description) {
		this.title = title;
		this.price = price;
		this.description = description;
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
	
}