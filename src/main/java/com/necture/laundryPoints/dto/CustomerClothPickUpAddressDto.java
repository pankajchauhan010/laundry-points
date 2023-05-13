package com.necture.laundryPoints.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Pankaj Chauhan
 * @since 7th May 2023
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerClothPickUpAddressDto {

	@NotBlank(message = "Address line one is mandatory")
	private String addressLineOne;

	private String AddressLineTwo;

	@NotBlank(message = "City is mandatory")
	private String city;

	@NotBlank(message = "State is mandatory")
	private String State;

	@NotBlank(message = "Country is mandatory")
	private String Country;

	@NotBlank(message = "Zip code is mandatory")
	@Size(max = 6, min = 6, message = "Zip code length must be 6 digit")
	private String zipCode;
}
