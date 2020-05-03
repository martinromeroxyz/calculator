package com.poc.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CalcResponseErrorAdvice {
	
	private static final String MANDATORY_PARAMS_ERROR_CODE = "Validation error";
	private static final String NOT_VALID_PARAMS_ERROR_CODE = "Operation error";
	
	@ExceptionHandler(BindException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleBadRequest(BindException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(MANDATORY_PARAMS_ERROR_CODE);
	}
    
	@ExceptionHandler({ RuntimeException.class, NullPointerException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handle() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(NOT_VALID_PARAMS_ERROR_CODE);
	}

}
