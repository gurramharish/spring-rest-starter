package com.hans.srs.model;

public class SRSErrorResponse {

	private String description;
	private String errorCode;
	
	public SRSErrorResponse(String errorCode, String description) {
		this.errorCode = errorCode;
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
