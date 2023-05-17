package com.necture.laundryPoints.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.necture.laundryPoints.dto.CustomerClothDeliveryAddressDto;
import com.necture.laundryPoints.entity.CustomerClothDeliveryAddress;
import com.necture.laundryPoints.repository.CustomerClothDeliveryAddressRepository;
import com.necture.laundryPoints.service.CustomerClothDeliveryAddressService;
import com.necture.laundryPoints.service.CustomerService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @since 14th May 2023
 *
 */
@RequiredArgsConstructor
@Service
public class CustomerClothDeliveryAddressServiceImpl implements CustomerClothDeliveryAddressService {

	private final CustomerClothDeliveryAddressRepository custDeliveryAddressRepository;
	
	private final CustomerService customerService;
	
	
	@Override
	public List<CustomerClothDeliveryAddress> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerClothDeliveryAddress findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerClothDeliveryAddress save(CustomerClothDeliveryAddress object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CustomerClothDeliveryAddress object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerClothDeliveryAddressDto saveDevliverAddress(CustomerClothDeliveryAddressDto data) {
		
		CustomerClothDeliveryAddress custData = custDeliveryAddressRepository.save(getCustomerDevliverAddress(data));
		
		if(Objects.nonNull(custData)) {
			data.setId(custData.getId());
			return data;
		}
		
		return new CustomerClothDeliveryAddressDto();
	}

	private CustomerClothDeliveryAddress 
		getCustomerDevliverAddress(CustomerClothDeliveryAddressDto data) {
		
		return CustomerClothDeliveryAddress.builder()
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
