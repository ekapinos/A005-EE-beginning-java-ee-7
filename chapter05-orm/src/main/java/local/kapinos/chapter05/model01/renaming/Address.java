package local.kapinos.chapter05.model01.renaming;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "T_ADDRESS")
@SecondaryTables({ @SecondaryTable(name = "t_city"), @SecondaryTable(name = "t_country") })
public class Address {
	@Id
//	@SequenceGenerator(name="my_seq_id_gen") // A lot of exceptions with EclipseLink
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq_id_gen")
	@TableGenerator(name="addressGen", table="MY_TABALE_ID_GEN")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="addressGen")

	private Long id;
	private String street1;
	private String street2;
	@Column(table = "t_city")
	private String city;
	@Column(table = "t_city")
	private String state;
	@Column(table = "t_city")
	private String zipcode;
	@Column(table = "t_country")
	private String country;
	
	// Constructors, getters, setters
	
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
}