package com.poc.calculator.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.poc.calculator.model.Result;
import com.poc.calculator.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {CalculatorController.class, CalculatorService.class})
@WebMvcTest
class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CalculatorService calculatorService;

	@Test
	@DisplayName("calculation result is correct")
	public void calculationResultIsCorrect() throws Exception {
		
		Mockito.when(calculatorService.operate(ArgumentMatchers.any()))
			.thenReturn(Result.builder().result("10").build());
		
	 	this.mockMvc.perform(get("/calc/add?op1=7&op2=3")).andDo(print()).andExpect(status().isOk())
	 		.andExpect(content().string(containsString("{\"result\":\"10\"}")));;
	}
}
