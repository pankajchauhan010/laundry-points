package com.necture.laundryPoints.restController;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.necture.laundryPoints.constant.RestApiUrlConstant;
import com.necture.laundryPoints.dto.CustomerDto;
import com.necture.laundryPoints.entity.Customer;
import com.necture.laundryPoints.service.CustomerService;

/**
 * 
 * @author Pankaj Chauhan
 * @since 25th March 2023
 *
 */

/**
 * 
 * This controller is used by only user for registration purpose. User can not
 * fetch all user Data.
 *
 */
@RestController
@RequestMapping(RestApiUrlConstant.API_ROOT_PATH + "/customer")
public class CustomerRestController {

	@Autowired
	CustomerService custService;

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
	public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto data) {
		return ResponseEntity.ok().body(custService.saveCustomer(data));
	}

	@GetMapping(value = "get-by-email/{email}")
	public ResponseEntity<CustomerDto> getCustomerData(@PathVariable String email) {
		return new ResponseEntity<CustomerDto>(custService.findByPrimaryEmail(email), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomer() {
		return ResponseEntity.ok().body(custService.findAll());
	}

}
