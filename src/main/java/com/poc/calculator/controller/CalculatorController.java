package com.poc.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.corp.calculator.TracerImpl;

@RestController
public class CalculatorController {
	
	TracerImpl tracer = new TracerImpl();

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		tracer.trace("message");
		
		return String.format("Hello %s!", name);
	}
}
