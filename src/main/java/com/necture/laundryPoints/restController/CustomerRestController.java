package com.necture.laundryPoints.restController;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.necture.laundryPoints.constant.RestApiUrlConstant;
import com.necture.laundryPoints.entity.Customer;
import com.necture.laundryPoints.service.CustomerService;

@RestController
@RequestMapping(RestApiUrlConstant.API_ROOT_PATH)
public class CustomerRestController {

	@Autowired
	CustomerService custService;

	@GetMapping(value = { "/customer/{id}", "Customer/{id}" })
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable UUID id) {
		return new ResponseEntity<Customer>(custService.findById(id), HttpStatus.OK);

	}
}
