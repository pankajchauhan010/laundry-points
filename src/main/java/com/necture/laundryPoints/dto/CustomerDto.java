package com.necture.laundryPoints.dto;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Pankaj Chauhan
 * @version 0.1
 * @since 7th May 2023
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {

	private UUID id;

	@NotBlank(message = "First name is mandatory")
	@Size(min = 3)
	private String firstName;

	@NotBlank(message = "Last name is mandatory")
	@Size(min = 3)
	private String lastName;

	private LocalDate dateOfBirth;

	// primary email
	@NotBlank(message = "Email is mandatory")
	private String primaryEmail;

	// primary mobile number
	@Column(name = "primary_mobile_number")
	private String mobileNumber;

	@NotBlank(message = "Warning: Password should be at least 8 "
			+ "characters long and contain at least one special character and one number.")
	@Size(min = 8)
	private String password;

}
