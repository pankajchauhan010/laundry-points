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
import com.necture.laundryPoints.dto.CustomerClothPickUpAddressDto;
import com.necture.laundryPoints.service.CustomerClothPickUpAddressService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @since 16th May 2023
 *
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = RestApiUrlConstant.API_ROOT_PATH + "/customer-pick-up-address")
public class CustomerClothPickUpAddressRestController {
	
	private final CustomerClothPickUpAddressService clothPickUpAddressService;

	
	@GetMapping("testing")
	public ResponseEntity<String> testing() {
		return ResponseEntity.ok().body("Testing");
	}
	
	@PostMapping(value = { "save", "Save" })
	public ResponseEntity<CustomerClothPickUpAddressDto> saveCustomerClothDevliverAddress(
			@Valid @RequestBody CustomerClothPickUpAddressDto data) {

		if(Objects.nonNull(data.getId())) {
			throw new RuntimeException("While saving the customer you can't pass id");
		}
		
		return ResponseEntity.ok().
				body(clothPickUpAddressService.savePickUpAddress(data));

	}
	
	@PutMapping(value = { "save", "Save" })
	public ResponseEntity<CustomerClothPickUpAddressDto> updateCustomerClothDevliverAddress(
			@Valid @RequestBody CustomerClothPickUpAddressDto data) {

		System.out.println("hiii");
		return ResponseEntity.ok().
				body(clothPickUpAddressService.savePickUpAddress(data));
	}
	
}
