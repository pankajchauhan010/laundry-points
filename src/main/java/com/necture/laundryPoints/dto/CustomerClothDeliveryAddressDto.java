package com.necture.laundryPoints.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerClothDeliveryAddressDto {

	private UUID id;

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

	@NotNull(message = "Customer id is mandatory to save customer address")
	private UUID custId;

}
