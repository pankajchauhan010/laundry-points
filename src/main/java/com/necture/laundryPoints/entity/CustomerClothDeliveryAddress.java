package com.necture.laundryPoints.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerClothDeliveryAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String addressLineOne;

	private String AddressLineTwo;

	private String city;

	@Column(name = "country_state")
	private String state;

	private String country;

	private String zipCode;

	@OneToMany
	private List<OrderCreationDetail> orderCreationDetails = new ArrayList<>();
}
