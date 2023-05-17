package com.necture.laundryPoints.restController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.necture.laundryPoints.constant.RestApiUrlConstant;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @date 14th May 2023
 *
 */

@RestController
@RequestMapping(path = RestApiUrlConstant.API_ROOT_PATH + "/order")
public class OrderCreationDetailRestController {

	@GetMapping("/testing")
	public ResponseEntity<String> testinng() {
		return ResponseEntity.ok().body("testing");
	}

}
