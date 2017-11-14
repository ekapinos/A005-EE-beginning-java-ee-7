package local.kapinos.chapter03.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import local.kapinos.chapter03.constraint.Email;

public class Customer {
	@NotNull
	@Size(min=2)
	private String firstName;
	private String lastName;
	@Email
	private String email;
	private String phoneNumber;
	@Past
	private Date dateOfBirth;

	@Valid
	private Address deliveryAddress;
	
	public Customer(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.deliveryAddress = address;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return deliveryAddress;
	}
	public void setAddress(Address address) {
		this.deliveryAddress = address;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", address=");
		builder.append(deliveryAddress);
		builder.append("]");
		return builder.toString();
	}

}
