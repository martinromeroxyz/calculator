package com.poc.calculator.exceptions;

public class ServiceException extends RuntimeException { 

	private static final long serialVersionUID = 1L;
	
	private final ErrorCode errorCode;

	public ServiceException(Throwable e) {
		super(e.getMessage(), e);
		this.errorCode = ErrorCode.GENERIC_ERROR;
	}

	public ServiceException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ServiceException(ErrorCode errorCode, Throwable e) {
		super(e.getMessage(), e);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
