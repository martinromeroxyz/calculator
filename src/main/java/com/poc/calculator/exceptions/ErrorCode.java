package com.poc.calculator.exceptions;

public enum ErrorCode {

	GENERIC_ERROR("Generic error while processing the request"),
	INVALID_OPERATION_ERROR("Invalid operation"),
	INVALID_PARAMS_ERROR("Invalid params for the current operation");

	private final String message;

	ErrorCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
