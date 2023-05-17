package com.necture.laundryPoints.service;

import java.util.UUID;

import com.necture.laundryPoints.dto.CustomerClothDeliveryAddressDto;
import com.necture.laundryPoints.entity.CustomerClothDeliveryAddress;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @since 14th May 2023
 * 
 *
 */
public interface CustomerClothDeliveryAddressService extends CrudService<CustomerClothDeliveryAddress, UUID>{

	CustomerClothDeliveryAddressDto saveDevliverAddress(CustomerClothDeliveryAddressDto data);
}
