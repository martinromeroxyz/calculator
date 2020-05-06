package com.poc.calculator.component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import org.springframework.stereotype.Component;

import com.poc.calculator.exceptions.ErrorCode;
import com.poc.calculator.exceptions.ServiceException;
import com.poc.calculator.model.Operation;

@Component
public class Calculator {
	
	public static final Map<String, BinaryOperator<Double>> operations = new HashMap<>();
	
	static {
		operations.put("add", (a, b) -> a + b);
		operations.put("substract", (a, b) -> a - b);
	}

	private BinaryOperator<Double> getOperation(String name) throws ServiceException {
		if(!operations.containsKey(name)) {
			throw new ServiceException(ErrorCode.INVALID_OPERATION_ERROR);
		}
		
		return operations.get(name);
	}
	
	private Double computeOperation(BinaryOperator<Double> op, Double op1, Double op2) {
		try {
			return op.apply(op1, op2);
			
		} catch(NullPointerException e) {
			throw new ServiceException(ErrorCode.INVALID_PARAMS_ERROR);
		}
	}
	
	public Double computeResult(Operation operation) throws ServiceException {
		BinaryOperator<Double> op = getOperation(operation.getName());
		return computeOperation(op, operation.getOp1(), operation.getOp2());
	}

}
