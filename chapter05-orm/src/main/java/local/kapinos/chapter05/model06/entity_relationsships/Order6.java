package local.kapinos.chapter05.model06.entity_relationsships;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order6 {
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name = "jnd_ord_line", 
//	           joinColumns = @JoinColumn(name = "order_fk"), 
//	           inverseJoinColumns = @JoinColumn(name = "order_line_fk"))
	@JoinColumn(name="order_id")
	private List<OrderLine6> orderLines;
	// Constructors, getters, setters
	
	public Order6(){
	}
	public Order6(Date creationDate, List<OrderLine6> orderLines) {
		this.creationDate = creationDate;
		this.orderLines = orderLines;
	}
	
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public List<OrderLine6> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine6> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}