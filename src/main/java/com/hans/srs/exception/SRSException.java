package com.hans.srs.exception;

import org.springframework.http.HttpStatus;

public class SRSException extends RuntimeException {

	private String message;
	private String errorCode;
	private HttpStatus httpStatus;
	
	public SRSException(String message, HttpStatus httpStatus) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public SRSException(String message, HttpStatus httpStatus, String errorCode) {
		this(message, httpStatus);
		this.errorCode = errorCode;
	}
	
	public SRSException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}
