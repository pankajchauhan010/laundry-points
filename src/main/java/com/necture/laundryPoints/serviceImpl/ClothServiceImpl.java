package com.necture.laundryPoints.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.necture.laundryPoints.dto.ClothDto;
import com.necture.laundryPoints.entity.Cloth;
import com.necture.laundryPoints.repository.ClothRepository;
import com.necture.laundryPoints.service.ClothService;

@Service
public class ClothServiceImpl implements ClothService {

	@Autowired
	ClothRepository clothRepo;

	@Override
	public List<Cloth> findAll() {

		List<Cloth> allClothData = clothRepo.findAll();
		if(!allClothData.isEmpty()) {
			return allClothData;
		}
		return new ArrayList<>();
	}

	@Override
	public Cloth findById(UUID id) {
		Optional<Cloth> clothData = clothRepo.findById(id);
		Cloth cloth = new Cloth();
		if (clothData.isPresent()) {
			return clothData.get();
		} else if (clothData.isEmpty()) {
			System.out.println("no data is present");
		}
		return cloth;
	}

	@Override
	public Cloth save(Cloth clothData) {
		Cloth cloth = clothRepo.save(clothData);
		if (Objects.nonNull(cloth)) {
			return cloth;
		}

		return null;
	}

	/**
	 * not used
	 */
	@Override
	public void delete(Cloth object) {

	}

	@Override
	public void deleteById(UUID id) {
		clothRepo.deleteById(id);
	}

	/**
	 * just for demo purpose
	 */
	@Override
	public ClothDto save(ClothDto clothData) {
		Cloth cloth = new Cloth();
		
		cloth.setClothName(clothData.getClothName());
		cloth.setPrice(clothData.getPrice());
		
		cloth = save(cloth);
		System.out.println(cloth);
		System.out.println();
		if(!Objects.isNull(cloth)) {
			clothData.setId(cloth.getId());
			return clothData;
		}
		return new ClothDto();
	}

}
