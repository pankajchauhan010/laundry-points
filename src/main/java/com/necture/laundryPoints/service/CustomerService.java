package com.necture.laundryPoints.service;

import java.util.UUID;

import com.necture.laundryPoints.dto.CustomerDto;
import com.necture.laundryPoints.entity.Customer;

public interface CustomerService extends CrudService<Customer, UUID> {
	
	CustomerDto saveCustomer(CustomerDto data);
	
	CustomerDto findByPrimaryEmail(String email);

}
