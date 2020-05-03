package com.poc.calculator.service;

import java.util.function.BinaryOperator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.calculator.component.Calculator;
import com.poc.calculator.helper.Formatter;
import com.poc.calculator.model.Operation;
import com.poc.calculator.model.Result;

@Service
public class CalculatorService {
	
	@Autowired
	Calculator calculator;
	
	@Autowired
	Formatter formatter;

	public Result operate(Operation operation) {
		
		return Result.builder().result(computeResult(operation)).build();
	}
	
	private String computeResult(Operation operation) {
		BinaryOperator<Double> op = Calculator.operations.get(operation.getName());
		return Formatter.normalizePrecisionResult(op.apply(operation.getOp1(), operation.getOp2()));
	}
	
}
