package com.necture.laundryPoints.service;

import java.util.UUID;

import com.necture.laundryPoints.dto.CustomerClothPickUpAddressDto;
import com.necture.laundryPoints.entity.CustomerClothPickUpAddress;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @since 16th May 2023
 *
 */
public interface CustomerClothPickUpAddressService extends 
		CrudService<CustomerClothPickUpAddress, UUID> {

	CustomerClothPickUpAddressDto savePickUpAddress(CustomerClothPickUpAddressDto data);

	
}
