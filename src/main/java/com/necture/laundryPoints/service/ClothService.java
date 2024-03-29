package com.necture.laundryPoints.service;

import java.util.UUID;

import com.necture.laundryPoints.dto.ClothDto;
import com.necture.laundryPoints.entity.Cloth;

public interface ClothService extends CrudService<Cloth, UUID>{
	
	public ClothDto save(ClothDto clothData);

}
