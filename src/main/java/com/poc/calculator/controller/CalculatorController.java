package com.poc.calculator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.calculator.exceptions.ServiceException;
import com.poc.calculator.model.Operation;
import com.poc.calculator.model.Result;
import com.poc.calculator.service.CalculatorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;

	@GetMapping("/calc/{name}")
	public ResponseEntity<Result> calc(@Valid Operation operation) throws ServiceException {
		
		log.info("Started {} operation", operation.getName());
		
		return new ResponseEntity<Result>(calculatorService.operate(operation), null, HttpStatus.OK);

	}
}

