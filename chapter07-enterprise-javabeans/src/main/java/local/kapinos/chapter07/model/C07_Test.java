package local.kapinos.chapter07.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: C07_Test
 *
 */
@SuppressWarnings("serial")
@Entity
public class C07_Test implements Serializable {

	@GeneratedValue
	@Id
	int id;
	
	private String value;

	public C07_Test() {

	}
	public C07_Test(String value) {
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
   
}
