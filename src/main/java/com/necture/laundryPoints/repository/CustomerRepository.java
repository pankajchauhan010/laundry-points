package com.necture.laundryPoints.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.necture.laundryPoints.entity.Customer;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @date 14th May 2023
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
	
	Optional<Customer> findByPrimaryEmail(String email);
	
	void deleteByPrimaryEmail(String email);

}
