package com.poc.calculator.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import org.springframework.stereotype.Service;

import com.poc.calculator.model.Operation;
import com.poc.calculator.model.Result;

@Service
public class CalculatorService {

	public Result operate(Operation operation) {
		
		Map<String, BinaryOperator<Double>> operations = new HashMap<>();
		operations.put("add", (a, b) -> a + b);
		operations.put("substract", (a, b) -> a - b);
		
		BinaryOperator<Double> op = operations.get(operation.getName());
		Double s = op.apply(operation.getOp1(), operation.getOp2());
		
		return Result.builder().result(String.valueOf(s)).build();
	}

}
