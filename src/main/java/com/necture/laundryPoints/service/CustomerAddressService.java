package com.necture.laundryPoints.service;

import java.util.Set;
import java.util.UUID;

import com.necture.laundryPoints.dto.CustomerAddressDto;
import com.necture.laundryPoints.entity.CustomerAddress;

public interface CustomerAddressService extends CrudService<CustomerAddress, UUID> {

	CustomerAddressDto saveCustomerAddress(CustomerAddressDto addressData);

	Set<CustomerAddressDto> getCustomerAddress(UUID id);

	Set<CustomerAddressDto> getCustomerAddress(String email);

	void deleteByCustomerEmailId(String email);

	void deleteByCusomterId(UUID id);
}
