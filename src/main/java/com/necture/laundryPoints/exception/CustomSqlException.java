package com.necture.laundryPoints.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pankaj
 * @version 0.1
 * @date 14th May 2023
 *
 */

@ControllerAdvice
public class CustomSqlException {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseBody
	public ResponseEntity<String> handleNumberFormatExceptions(Exception exc) {
		exc.printStackTrace();
		return ResponseEntity.ok("Please enter valid value");
	}
}
