package com.necture.laundryPoints.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.necture.laundryPoints.dto.CustomerClothPickUpAddressDto;
import com.necture.laundryPoints.entity.CustomerClothPickUpAddress;
import com.necture.laundryPoints.repository.CustomerClothPickUpAddressRepository;
import com.necture.laundryPoints.service.CustomerClothPickUpAddressService;
import com.necture.laundryPoints.service.CustomerService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @since 16th May 2023
 *
 */

@Service
@RequiredArgsConstructor
public class CustomerClothPickUpAddressServiceImpl implements CustomerClothPickUpAddressService {

	private final CustomerClothPickUpAddressRepository clothPickUpAddressRepository;
	
	private final CustomerService customerService;
	
	@Override
	public List<CustomerClothPickUpAddress> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerClothPickUpAddress findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerClothPickUpAddress save(CustomerClothPickUpAddress object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CustomerClothPickUpAddress object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerClothPickUpAddressDto savePickUpAddress(CustomerClothPickUpAddressDto data) {
		
		clothPickUpAddressRepository.save(getCustomerPickUpAddress(data));
		return null;
	}

	private CustomerClothPickUpAddress getCustomerPickUpAddress(CustomerClothPickUpAddressDto data) {

		return CustomerClothPickUpAddress.builder()
		.addressLineOne(data.getAddressLineOne())
		.addressLineTwo(data.getAddressLineTwo())
		.city(data.getCity())
		.state(data.getState())
		.country(data.getCountry())
		.zipCode(data.getZipCode())
		.customer(customerService.findById(data.getCustId()))
		.build();
	}

}
