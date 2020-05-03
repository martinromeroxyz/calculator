package com.poc.calculator.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.calculator.model.Operation;
import com.poc.calculator.model.Result;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CalculatorController {

	@GetMapping("/calc/{name}")
	public ResponseEntity<Result> calc(@Valid Operation operation) {
		
		log.info("Started {} operation", operation.getName());
		
		return new ResponseEntity<Result>(Result.builder().result("0").build(), null, HttpStatus.OK);

	}
}
