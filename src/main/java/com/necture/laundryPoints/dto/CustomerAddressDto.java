package com.necture.laundryPoints.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Pankaj Chauhan
 * @version 0.1
 * @since 7th May 2023
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerAddressDto {
	
	private UUID id;

	private String mobileNumber;

	@NotNull(message = "Address line one in mandtory")
	@Size(min = 3)
	private String addressLineOne;

	private String addressLineTwo;

	private String city;

	private String state;

	private String country;

	private String zipCode;

	// this mandatory to save the user address
//	@NotNull(message = "user name is mandatory")
//	private String primaryEmail;

	@NotNull(message = "Customer id is mandatory")
	private UUID custId;

}
