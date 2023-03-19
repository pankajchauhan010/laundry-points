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
		return new ResponseEntity<>(clothData, HttpStatus.OK);
	}

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
		System.out.println(clothData);
		Cloth cloth = clothService.save(clothData);
		return new ResponseEntity<>(cloth, HttpStatus.OK);
	}

	@PutMapping(value = { "update", "update" })
	public ResponseEntity<Cloth> update(@Valid @RequestBody Cloth clothData) {
		Cloth cloth = clothService.save(clothData);
		return new ResponseEntity<>(cloth, HttpStatus.OK);
	}

	/*
	 * deleting existing cloth by using cloth id
	 */
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable UUID id) {
		System.out.println("you are visited");
		clothService.deleteById(id);
	}

}
