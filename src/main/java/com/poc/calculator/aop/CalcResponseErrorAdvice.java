package com.poc.calculator.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.poc.calculator.exceptions.ErrorCode;
import com.poc.calculator.exceptions.ServiceException;

@ControllerAdvice
public class CalcResponseErrorAdvice {
	
	@ExceptionHandler({ RuntimeException.class, NullPointerException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handle() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorCode.GENERIC_ERROR.getMessage());
	}
	
	@ExceptionHandler(BindException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleBadRequest(BindException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorCode.INVALID_PARAMS_ERROR.getMessage());
	}
	
	@ExceptionHandler({ ServiceException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handle(ServiceException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(e.getMessage());
	}

}
