package com.necture.laundryPoints.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	private String firstName;

	private String lastName;

	private LocalDateTime dateOfBirth;

	// primary email
	private String primaryEmail;

	// primary mobile number
	@Column(name = "primary_mobile_number")
	private String mobileNumber;

	private String password;

	// one to many relation
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<CustomerAddress> custAddress = new ArrayList<>();
	
	@OneToMany(mappedBy = "customer")
	private List<OrderCreationDetail> orderCreationDetails = new ArrayList<>();

	public UUID getId() {
		return id;
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

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CustomerAddress> getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(List<CustomerAddress> custAddress) {
		this.custAddress = custAddress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", primaryEmail=" + primaryEmail + ", mobileNumber=" + mobileNumber + ", password="
				+ password + "]";
	}

}
