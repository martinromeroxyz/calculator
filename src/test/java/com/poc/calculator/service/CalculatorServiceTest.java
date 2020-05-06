package com.poc.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.poc.calculator.component.Calculator;
import com.poc.calculator.exceptions.ServiceException;
import com.poc.calculator.model.Operation;
import com.poc.calculator.model.Result;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {
	
	@InjectMocks
	private CalculatorService calculatorService;

	@Spy
	private Calculator calculator;
	
	@Test	
	@DisplayName("add two numbers")
	void addTwoNumbers() throws ServiceException {
		
		Result expected = Result.builder().result("7").build();
		Result actual = calculatorService.operate(getOperation("add"));

		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("substract two numbers")
	void substractTwoNumbers() throws ServiceException {

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

