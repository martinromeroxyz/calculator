package com.poc.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.calculator.component.Calculator;
import com.poc.calculator.exceptions.ServiceException;
import com.poc.calculator.helper.Formatter;
import com.poc.calculator.model.Operation;
import com.poc.calculator.model.Result;

@Service
public class CalculatorService {
	
	@Autowired
	private Calculator calculator;


	public Result operate(Operation operation) throws ServiceException {
		
		return Result.builder().result(Formatter.normalizePrecisionResult(calculator.computeResult(operation))).build();
	}
	
}
