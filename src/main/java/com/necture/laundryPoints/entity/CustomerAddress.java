package com.necture.laundryPoints.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customerAddress")
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = -4396252858066220997L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	// use with address
	private String mobileNumber;

	private String addressLineOne;

	private String addressLineTwo;

	private String city;

	@Column(name = "country_state")
	private String state;

	private String country;

	private String zipCode;

	// one to many manyToOne
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CustomerAddress [id=" + id + ", mobileNumber=" + mobileNumber + ", addressLineOne=" + addressLineOne
				+ ", addressLineTwo=" + addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipCode=" + zipCode + "]";
	}

}
