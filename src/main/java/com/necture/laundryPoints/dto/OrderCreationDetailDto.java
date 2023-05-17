package com.necture.laundryPoints.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

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
public class OrderCreationDetailDto {

	private Integer quantity;

	private LocalDateTime pickUpDate;

	private LocalDateTime deliveryDate;

	// used to refer the customer
	@NotBlank(message = "email is mandtory to create order")
	private String primaryEmail;
	
	
	// use to refer the customer address that is providing during creation of account
	private UUID custAddressId;
	
	@NotBlank(message = "Customer pick id is mandatory")
	private UUID custPickUpAddressId;

	@NotBlank(message = "Customer deliver id is mandatory")
	private UUID custDeliveryAddressId;

	@NotBlank(message = "cloth name is mandatory")
	private String clothName;
}
