package local.kapinos.chapter05.model01;

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
}