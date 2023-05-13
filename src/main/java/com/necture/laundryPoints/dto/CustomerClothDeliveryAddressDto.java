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
public class CustomerClothDeliveryAddressDto {

	@NotBlank(message = "Address line one is mandatory")
	@Size(min = 3)
	private String addressLineOne;

	private String AddressLineTwo;

	@NotBlank(message = "City is mandatory")
	private String city;

	@NotBlank(message = "State is mandatory")
	private String state;

	@NotBlank(message = "Country is mandatory")
	private String country;

	@NotBlank(message = "zip code is mandatory")
	private String zipCode;

}
