package com.poc.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.poc.calculator.model.Operation;
import com.poc.calculator.model.Result;

public class CalculatorServiceTest {
	
	CalculatorService calculatorService;
	
	@BeforeEach
	void init() {
		calculatorService = new CalculatorService();
	}
	
	@Test
	@DisplayName("add two numbers")
	void addTwoNumbers() {

		Result expected = Result.builder().result("7").build();
		Result actual = calculatorService.operate(getOperation("add"));

		assertEquals(expected, actual);

	}
	
	@Test
	@DisplayName("substract two numbers")
	void substractTwoNumbers() {

		Result expected = Result.builder().result("1").build();
		Result actual = calculatorService.operate(getOperation("substract"));

		assertEquals(expected, actual);

	}

	// MOCK DATA
	
	private Operation getOperation(String name) {
		Operation operation = new Operation();
		operation.setName(name);
		operation.setOp1(4.0);
		operation.setOp2(3.0);
		
		return operation;
	}

}

