package com.necture.laundryPoints.restController;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.necture.laundryPoints.constant.RestApiUrlConstant;
import com.necture.laundryPoints.dto.CustomerClothDeliveryAddressDto;
import com.necture.laundryPoints.service.CustomerClothDeliveryAddressService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @since 14th May 2023
 *
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(path = RestApiUrlConstant.API_ROOT_PATH + "/customer-deliver-address")
public class CustomerClothDeliveryAddressRestController {

	private final CustomerClothDeliveryAddressService customerClothDeliveryAddressService;

	@GetMapping
	public ResponseEntity<String> getCustomerClothDevliverAddress() {
		return ResponseEntity.ok().body("ok");
	}

	@PostMapping(value = { "save", "Save" })
	public ResponseEntity<CustomerClothDeliveryAddressDto> saveCustomerClothDevliverAddress(
			@Valid @RequestBody CustomerClothDeliveryAddressDto data) {

		System.out.println("hiii");
		if(Objects.nonNull(data.getId())) {
			throw new RuntimeException("While saving the customer you can't pass id");
		}
		
		return ResponseEntity.ok().
				body(customerClothDeliveryAddressService.saveDevliverAddress(data));

	}
	
	@PutMapping(value = { "save", "Save" })
	public ResponseEntity<CustomerClothDeliveryAddressDto> updateCustomerClothDevliverAddress(
			@Valid @RequestBody CustomerClothDeliveryAddressDto data) {

		System.out.println("hiii");
		return ResponseEntity.ok().
				body(customerClothDeliveryAddressService.saveDevliverAddress(data));
	}

}
