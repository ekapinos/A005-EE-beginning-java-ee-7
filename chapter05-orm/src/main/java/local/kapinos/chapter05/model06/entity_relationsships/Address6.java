package local.kapinos.chapter05.model06.entity_relationsships;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address6 {
	@Id
	@GeneratedValue
	private Long id;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	@OneToOne(mappedBy="address")
	Customer6 customer;
	// Constructors, getters, setters
	public Address6(){
	}
	public Address6(String street1, String street2, String city, String state, String zipcode, String country) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Customer6 getCustomer() {
		return customer;
	}
	public void setCustomer(Customer6 customer) {
		this.customer = customer;
	}
}