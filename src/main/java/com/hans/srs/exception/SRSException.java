package com.hans.srs.exception;

import org.springframework.http.HttpStatus;

public class SRSException extends RuntimeException {

	private String message;
	private HttpStatus httpStatus;
	private ErrorCode errorCode;
	
	public SRSException(String message, HttpStatus httpStatus) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public SRSException(String message, HttpStatus httpStatus, ErrorCode errorCode) {
		this(message, httpStatus);
		this.errorCode = errorCode;
	}
	
	public SRSException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public String getErrorCode() {
		return errorCode != null ? errorCode.getCode() : null;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}
