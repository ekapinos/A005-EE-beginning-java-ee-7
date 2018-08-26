package local.kapinos.chapter12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {
	@XmlAttribute
	private String number;
	@XmlElement(name = "expiry_date")
	private String expiryDate;
	@XmlElement(name = "control_number")
	private Integer controlNumber;
	private String type;
	
	// Constructors, getters, setters

	public CreditCard(String number, String expiryDate, Integer controlNumber, String type) {
		this.number = number;
		this.expiryDate = expiryDate;
		this.controlNumber = controlNumber;
		this.type = type;
	}

	public CreditCard() {
	}

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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CreditCard [number=" + number + 
				", expiryDate=" + expiryDate + 
				", controlNumber=" + controlNumber +
				", type=" + type + 
				"]";
	}

}
