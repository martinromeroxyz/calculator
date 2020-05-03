package com.poc.calculator.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Operation {
	
	private String name;
	@NotNull
	private Double op1;
	private Double op2;
	
}
