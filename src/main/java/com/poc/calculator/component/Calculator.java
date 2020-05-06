package com.poc.calculator.component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import org.springframework.stereotype.Component;

import com.poc.calculator.model.Operation;

@Component
public class Calculator {
	
	public static final Map<String, BinaryOperator<Double>> operations = new HashMap<>();
	
	static {
		operations.put("add", (a, b) -> a + b);
		operations.put("substract", (a, b) -> a - b);
	}
	
	public Double computeResult(Operation operation) {
		BinaryOperator<Double> op = operations.get(operation.getName());
		return op.apply(operation.getOp1(), operation.getOp2());
	}

}
