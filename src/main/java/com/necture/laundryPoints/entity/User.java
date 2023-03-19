package com.necture.laundryPoints.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

//@Entity
public class User {

	private String id;

	private String firstName;

	private String lastName;

	private LocalDateTime dateOfBirth;

	// primary email
	private String email;

	// primary mobile number
	private String mobileNo;
	
	
	private String password;

	// one to many relation
	private UserAddress address;

}
