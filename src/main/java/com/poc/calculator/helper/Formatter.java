package com.poc.calculator.helper;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

@Component
public class Formatter {
	
	public static String normalizePrecisionResult(double d) {
		return (d == (long) d) ? String.format("%d",(long)d) : String.format("%s",new DecimalFormat("#.##").format(d));
	}
}
