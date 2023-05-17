package com.necture.laundryPoints.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.necture.laundryPoints.entity.CustomerClothDeliveryAddress;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @since 14th May 2023
 *
 */
public interface CustomerClothDeliveryAddressRepository extends 
	JpaRepository<CustomerClothDeliveryAddress, UUID> {

	
}
