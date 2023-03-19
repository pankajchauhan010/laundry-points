package com.necture.laundryPoints.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

//@Entity
public class Employee extends TableOperation {

	private String id;

	private String firstName;

	private String middleName;

	private String lastName;

	private LocalDateTime joinDate;

	private LocalDateTime resignDate;

	// it is unique
	private String userName;

	private String emailId;

}
