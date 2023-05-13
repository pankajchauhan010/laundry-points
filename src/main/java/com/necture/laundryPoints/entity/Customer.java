package com.necture.laundryPoints.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 4964124355044378331L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String firstName;

	private String lastName;

	private LocalDate dateOfBirth;

	// primary email
	private String primaryEmail;

	// primary mobile number
	@Column(name = "primary_mobile_number")
	private String mobileNumber;

	private String password;

	// one to many relation
	@Default
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<CustomerAddress> custAddress = new ArrayList<>();

	@Default
	@OneToMany(mappedBy = "customer")
	private List<OrderCreationDetail> orderCreationDetails = new ArrayList<>();

}
