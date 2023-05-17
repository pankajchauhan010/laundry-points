package com.necture.laundryPoints.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.necture.laundryPoints.dto.CustomerDto;
import com.necture.laundryPoints.entity.Customer;
import com.necture.laundryPoints.repository.CustomerRepository;
import com.necture.laundryPoints.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository custRepo;

	@Override
	public List<Customer> findAll() {
		return custRepo.findAll();
	}

	@Override
	public Customer findById(UUID id) {
		Optional<Customer> customerData = custRepo.findById(id);
		if (customerData.isPresent()) {
			return customerData.get();
		}
		return new Customer();
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto data) {
		
		Customer customerData = custRepo.save(getCustomerData(data));
		
		if (Objects.nonNull(customerData)) {
			data.setId(customerData.getId());
//			data.setPassword("");
			return data;
		}

		return new CustomerDto();
	}

	

	@Override
	public Customer save(Customer data) {
		return null;
	}

	/**
	 * User can delete their account
	 */
	@Override
	public void delete(Customer object) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void deleteById(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerDto findByPrimaryEmail(String email) {
		Optional<Customer> customerData = custRepo.findByPrimaryEmail(email);
		
		if (customerData.isPresent()) {
			return getCustomerDtoData(customerData.get());
		}
		return null;
	}
	
	private Customer getCustomerData(CustomerDto data) {
		return Customer.builder()
				.id(data.getId())
				.firstName(data.getFirstName())
				.lastName(data.getLastName())
				.primaryEmail(data.getPrimaryEmail())
				.dateOfBirth(data.getDateOfBirth())
				.mobileNumber(data.getMobileNumber())
				.password(data.getPassword())
				.build();
	}

	private CustomerDto getCustomerDtoData(Customer data) {
		CustomerDto customerDto =  new CustomerDto();
		customerDto.setId(data.getId());
		customerDto.setFirstName(data.getFirstName());
		customerDto.setLastName(data.getFirstName());
		customerDto.setPrimaryEmail(data.getPrimaryEmail());
		customerDto.setDateOfBirth(data.getDateOfBirth());
		customerDto.setMobileNumber(data.getMobileNumber());
//		customerDto.setPassword("");
		
		return customerDto;
	}

	/**
	 * we can delete by email id just for demo purpose
	 */
	@Override
	public void deleteByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

}
