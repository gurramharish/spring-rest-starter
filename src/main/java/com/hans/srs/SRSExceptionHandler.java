package com.hans.srs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hans.srs.exception.SRSException;
import com.hans.srs.model.SRSErrorResponse;

@ControllerAdvice
public class SRSExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(SRSException.class)
	public final ResponseEntity<SRSErrorResponse> handleSRSException(SRSException e) {
		System.out.println("SRSException :: preparing error response object");
		SRSErrorResponse errorResponse = new SRSErrorResponse(e.getErrorCode(), e.getLocalizedMessage());
		HttpStatus httpStatus = e.getHttpStatus() != null ? e.getHttpStatus() : HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity<SRSErrorResponse>(errorResponse, httpStatus);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<SRSErrorResponse> handleOtherExceptions(Exception e) {
		e.printStackTrace();
		SRSErrorResponse errorResponse = new SRSErrorResponse("5000", "Internal Server Error, please try after sometime");
		return new ResponseEntity<SRSErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
