package com.necture.laundryPoints.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.necture.laundryPoints.dto.CustomerAddressDto;
import com.necture.laundryPoints.entity.CustomerAddress;
import com.necture.laundryPoints.repository.CustomerAddressRepository;
import com.necture.laundryPoints.service.CustomerAddressService;
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
public class CustomerAddressServiceImpl implements CustomerAddressService {

	private final CustomerAddressRepository customerAddressRepository;

	private final CustomerService customerService;

	@Override
	public List<CustomerAddress> findAll() {
		return null;
	}

	@Override
	public CustomerAddress findById(UUID id) {
		return null;
	}

	@Override
	public CustomerAddress save(CustomerAddress data) {
		return customerAddressRepository.save(data);
	}

	@Override
	public void delete(CustomerAddress object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(UUID id) {
		customerAddressRepository.deleteById(id);
	}

	@Override
	public CustomerAddressDto saveCustomerAddress(CustomerAddressDto addressData) {
		CustomerAddress customerData = this.save(getCustomerAddress(addressData));

		if (Objects.nonNull(customerData.getId())) {
			addressData.setId(customerData.getId());
			return addressData;
		}
		return new CustomerAddressDto();
	}

	private CustomerAddress getCustomerAddress(CustomerAddressDto addressData) {

		CustomerAddress address = new CustomerAddress();

		address.setAddressLineOne(addressData.getAddressLineOne());
		address.setAddressLineTwo(addressData.getAddressLineTwo());
		address.setCity(addressData.getCity());
		address.setState(addressData.getState());
		address.setCountry(addressData.getCountry());
		address.setZipCode(addressData.getZipCode());
		address.setCustomer(customerService.findById(addressData.getCustId()));

		return address;
	}

	@Override
	public Set<CustomerAddressDto> getCustomerAddress(UUID id) {
		return setCustomerAddressData(customerAddressRepository.findByCustomerId(id));
	}

	@Override
	public Set<CustomerAddressDto> getCustomerAddress(String email) {

		return setCustomerAddressData(customerAddressRepository.findByCustomerPrimaryEmail(email));
	}
	
	@Override
	public void deleteByCustomerEmailId(String email) {
		customerAddressRepository.deleteByCustomerPrimaryEmail(email);
	}
	
	@Override
	public void deleteByCusomterId(UUID id) {
		customerAddressRepository.deleteByCustomerId(id);
	}

	private Set<CustomerAddressDto> setCustomerAddressData(Set<CustomerAddress> customerAddress) {

		Set<CustomerAddressDto> data = new HashSet<>();
		customerAddress.stream().forEach(custData -> {

			CustomerAddressDto customerAddressData = CustomerAddressDto.builder()
					.addressLineOne(custData.getAddressLineOne())
					.addressLineTwo(custData.getAddressLineTwo())
					.mobileNumber(custData.getMobileNumber())
					.city(custData.getCity())
					.state(custData.getState())
					.country(custData.getCountry())
					.zipCode(custData.getZipCode()).build();
			data.add(customerAddressData);

		});
		return data;
	}

	

	

}
