package com.necture.laundryPoints.restController;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.necture.laundryPoints.constant.RestApiUrlConstant;
import com.necture.laundryPoints.dto.CustomerDto;
import com.necture.laundryPoints.entity.Customer;
import com.necture.laundryPoints.service.CustomerService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Pankaj Chauhan
 * @version 0.1
 * @since 25th March 2023
 *
 */

/**
 * 
 * This controller is used by only user for registration purpose. User can not
 * fetch all user Data.
 *
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(RestApiUrlConstant.API_ROOT_PATH + "/customer")
public class CustomerRestController {

	private final CustomerService custService;

	/**
	 * 
	 * @param id
	 * @return this will return single customer data at a time.
	 */
	@GetMapping(value = "{id}")
	public ResponseEntity<Customer> getCustomerData(@PathVariable UUID id) {
		return new ResponseEntity<Customer>(custService.findById(id), HttpStatus.OK);
	}

	@PostMapping(value = { "Save-Customer", "save-customer" })
	public ResponseEntity<CustomerDto> saveCustomer(@Valid @RequestBody CustomerDto data) {
		if(Objects.nonNull(data.getId())) {
			throw new RuntimeException("To create new customer id must be empaty or null");
		}
		return ResponseEntity.ok().body(custService.saveCustomer(data));
	}

	@GetMapping(value = "email/{email}")
	public ResponseEntity<CustomerDto> getCustomerData(@PathVariable String email) {
		return new ResponseEntity<CustomerDto>(custService.findByPrimaryEmail(email), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 * testing pending
	 */
	@PutMapping(value = { "Save-Customer", "save-customer" })
	public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto data) {
		return ResponseEntity.ok().body(custService.saveCustomer(data));
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomer() {
		return ResponseEntity.ok().body(custService.findAll());
	}

	
	/**
	 * Deleting customer is not implemented
	 */
	
}
