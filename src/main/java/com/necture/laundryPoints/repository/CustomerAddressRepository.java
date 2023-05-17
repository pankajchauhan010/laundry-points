package com.necture.laundryPoints.repository;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.necture.laundryPoints.entity.CustomerAddress;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @since 14th May 2023
 *
 */
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, UUID> {

	Set<CustomerAddress> findByCustomerId(UUID id);
	
	Set<CustomerAddress> findByCustomerPrimaryEmail(String primaryEmail);
	
	@Transactional
	@Modifying
	void deleteByCustomerPrimaryEmail(String primaryEmail);
	
	@Transactional
	@Modifying
	void deleteByCustomerId(UUID id);

}
