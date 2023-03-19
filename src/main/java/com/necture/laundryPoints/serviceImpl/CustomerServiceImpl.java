package com.necture.laundryPoints.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.necture.laundryPoints.entity.Customer;
import com.necture.laundryPoints.repository.CustomerRepository;
import com.necture.laundryPoints.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository custRepo;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(UUID id) {
		Optional<Customer> customerData = custRepo.findById(id);
		if(customerData.isPresent()) {
			return customerData.get();
		}
		return new Customer();
	}

	@Override
	public Customer save(Customer object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customer object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(UUID id) {
		// TODO Auto-generated method stub

	}

}
