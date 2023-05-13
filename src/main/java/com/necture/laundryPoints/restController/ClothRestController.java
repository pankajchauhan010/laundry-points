package com.necture.laundryPoints.restController;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.necture.laundryPoints.constant.RestApiUrlConstant;
import com.necture.laundryPoints.entity.Cloth;
import com.necture.laundryPoints.service.ClothService;

@RestController
@RequestMapping(path = RestApiUrlConstant.API_ROOT_PATH + "/cloth")
public class ClothRestController {

	@Autowired
	ClothService clothService;

	/*
	 * getting cloth details by using cloth id
	 */
	@GetMapping(value = "{id}")
	public ResponseEntity<Cloth> getSingleCloth(@PathVariable UUID id) {
		Cloth clothData = clothService.findById(id);
		return ResponseEntity.ok(clothData);
	}

	/* *
	 * getting all cloth details
	 * this can be no useful when user want to access it
	 * block this so user can't access it 
	 * This is only for admin
	 * */
	@GetMapping(value = "")
	public ResponseEntity<List<Cloth>> getAllCloth() {
		List<Cloth> clothData = clothService.findAll();
		return new ResponseEntity<>(clothData, HttpStatus.OK);
	}

	/*
	 * creating new cloth
	 */
	@PostMapping(value = { "/save", "Save" })
	public ResponseEntity<Cloth> save(@Valid @RequestBody Cloth clothData) {
		Cloth cloth = clothService.save(clothData);
		return ResponseEntity.ok(cloth);
	}

	@PutMapping(value = { "update", "update" })
	public ResponseEntity<Cloth> update(@Valid @RequestBody Cloth clothData) {
		Cloth cloth = clothService.save(clothData);
		return ResponseEntity.ok(cloth);
	}

	/*
	 * deleting existing cloth by using cloth id
	 * This has been not deleted.
	 * This is just for demo purpose
	 */
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable UUID id) {
		clothService.deleteById(id);
	}

}
