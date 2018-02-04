package local.kapinos.chapter05.model03.enums_accesstype;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card")
@Access(AccessType.PROPERTY)
public class CreditCard {
	private String number;
	private String expiryDate;
	private Integer controlNumber;
	private CreditCardType creditCardType;
	
	// Constructors, getters, setters
	
	public CreditCard() {
	}
	public CreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType creditCardType) {
		this.number = number;
		this.expiryDate = expiryDate;
		this.controlNumber = controlNumber;
		this.creditCardType = creditCardType;
	}
	@Id
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(Integer controlNumber) {
		this.controlNumber = controlNumber;
	}
	@Enumerated(EnumType.STRING)
	public CreditCardType getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}
	
	public int getAbc() {
		return 101;
	}
	public void setAbc(int abc) {
		
	}
	
}