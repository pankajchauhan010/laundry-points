package com.necture.laundryPoints.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerClothPickUpAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String addressLineOne;
	
	private String AddressLineTwo;
	
	private String city;
	
	private String State;
	
	private String Country;
	
	private String zipCode;
	
	@OneToMany
	private List<OrderCreationDetail> orderCreationDetails = new ArrayList<>();
	
}
