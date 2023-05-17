package com.necture.laundryPoints.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 
 * @author Pankaj Chauhan
 * @date 25th Match 2023
 * @version 0.1
 */
@ControllerAdvice
public class CustomIllegalArgumentExceptionController {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public ResponseEntity<String> handleNumberFormatExceptions(Exception exc) {
		exc.printStackTrace();
		return new ResponseEntity<String>("Please enter valid value", HttpStatus.OK);
	}

}
