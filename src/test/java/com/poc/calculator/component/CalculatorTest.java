package com.poc.calculator.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.poc.calculator.exceptions.ServiceException;
import com.poc.calculator.model.Operation;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {
	
	@InjectMocks
	private Calculator calculator;
	
	@Test	
	@DisplayName("compute add two numbers")
	void computeAddTwoNumbers() throws ServiceException {
		
		Double expected = Double.valueOf(7);
		Double actual = calculator.computeResult(getOperation(ADD_OPERATION_NAME));

		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("compute substract two numbers")
	void computeSubstractTwoNumbers() throws ServiceException {

		Double expected = Double.valueOf("1");
		Double actual = calculator.computeResult(getOperation(SUBSTRACT_OPERATION_NAME));

		assertEquals(expected, actual);
	}
	
	@Test
	void testExpectedServiceException_whenOperationDoesNotExists() {
	 
	  Exception e = Assertions.assertThrows(ServiceException.class, () -> {
		  calculator.computeResult(getOperation(INEXISTENT_OPERATION_NAME));
	  });
	  
	  assertTrue("Invalid operation".equals(e.getMessage()));
	}
	
	@Test
	void testExpectedServiceException_whenParamsDoesNotMatchOperation() {
	 
	  Exception e = Assertions.assertThrows(ServiceException.class, () -> {
		  calculator.computeResult(getWrongOperation(ADD_OPERATION_NAME));
	  });
	  
	  assertTrue("Invalid params for the current operation".equals(e.getMessage()));
	}
	
	// MOCK DATA
	
	private static String ADD_OPERATION_NAME = "add";
	private static String SUBSTRACT_OPERATION_NAME = "substract";
	private static String INEXISTENT_OPERATION_NAME = "none";
	
	private Operation getOperation(String name) {
		Operation operation = new Operation();
		operation.setName(name);
		operation.setOp1(4.0);
		operation.setOp2(3.0);
		
		return operation;
	}
	
	private Operation getWrongOperation(String name) {
		Operation operation = new Operation();
		operation.setName(name);
		operation.setOp1(4.0);
		operation.setOp2(null);
		
		return operation;
	}

}
