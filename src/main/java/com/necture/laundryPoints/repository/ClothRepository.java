package com.necture.laundryPoints.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.necture.laundryPoints.entity.Cloth;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @date 14th May 2023
 *
 */

public interface ClothRepository extends JpaRepository<Cloth, UUID> {

}
