package com.necture.laundryPoints.restController;

import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.necture.laundryPoints.constant.RestApiUrlConstant;
import com.necture.laundryPoints.dto.CustomerAddressDto;
import com.necture.laundryPoints.service.CustomerAddressService;

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
@RequestMapping(path = RestApiUrlConstant.API_ROOT_PATH + "/customer-address")
public class CustomerAddressRestController {
	
	private final CustomerAddressService customerAddressService;

	/**
	 * Testing purpose
	 * @return
	 */
	@GetMapping
	public ResponseEntity<String> getData() {
		return ResponseEntity.ok().body("testing");
	}
	
	/**
	 * Get customer address details with customer id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "customer-id/{id}")
	public ResponseEntity<Set<CustomerAddressDto>> getCustomerAddress(@PathVariable UUID id) {
		return ResponseEntity.ok().body(customerAddressService.getCustomerAddress(id));
	}
	
	/**
	 * Get customer address details with customer email
	 * @param email
	 * @return
	 */
	@GetMapping(value = "customer-email/{email}")
	public ResponseEntity<Set<CustomerAddressDto>> getCustomerAddress(@PathVariable String email) {
		return ResponseEntity.ok().body(customerAddressService.getCustomerAddress(email));
	}
	
	
	/**
	 * saving customer address
	 * @param data
	 * @return
	 */
	@PostMapping(value = {"save", "Save"})
	public ResponseEntity<CustomerAddressDto> saveCustomer(@Valid @RequestBody CustomerAddressDto data) {
		System.out.println("hiii");
		return ResponseEntity.ok().body(customerAddressService.saveCustomerAddress(data));
	}
	
	/**
	 * updating customer address
	 * @param data
	 * @return
	 */
	@PutMapping(value = {"save", "Save"})
	public ResponseEntity<CustomerAddressDto> updateCustomer(@Valid @RequestBody CustomerAddressDto data) {
		System.out.println("hiii");
		return ResponseEntity.ok().body(customerAddressService.saveCustomerAddress(data));
	}
	
	
	@DeleteMapping(value = {"delete-id/{id}", "Delete-id/{id}"})
	public  ResponseEntity<String>  deleteCustomerAddress(@PathVariable UUID id) {
		customerAddressService.deleteById(id);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"delete-email/{email}", "Delete-email/{email}"})
	public  ResponseEntity<String>  deleteCustomerAddress(@PathVariable String email) {
		customerAddressService.deleteByCustomerEmailId(email);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
	
	/**
	 * We can delete customer address by customer id
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = {"delete-customer-id/{id}", "Delete-customer-id/{id}"})
	public  ResponseEntity<String>  deleteCustomerAddressByCustomerId(@PathVariable UUID id) {
		customerAddressService.deleteByCusomterId(id);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
	
}
