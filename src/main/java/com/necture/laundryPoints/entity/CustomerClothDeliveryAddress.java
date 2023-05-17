package com.necture.laundryPoints.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @date 14th May 2023
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerClothDeliveryAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String addressLineOne;

	private String addressLineTwo;

	private String city;

	@Column(name = "country_state")
	private String state;

	private String country;

	private String zipCode;

	@OneToMany(mappedBy = "custPickUpAddress")
	private List<OrderCreationDetail> orderCreationDetails = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
}
