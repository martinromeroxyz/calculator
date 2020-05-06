package com.poc.calculator.helper;

import java.text.DecimalFormat;

public class Formatter {
	
	public static String normalizePrecisionResult(double d) {
		return (d == (long) d) ? String.format("%d",(long)d) : String.format("%s",new DecimalFormat("#.##").format(d));
	}
}
