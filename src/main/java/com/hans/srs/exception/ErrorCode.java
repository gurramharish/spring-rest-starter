package com.hans.srs.exception;

public enum ErrorCode {

	USER_NOT_FOUND("SRS-1000"),
	UNAUTHORIZED_ACCESS("SRS-4000"),
	CODE_SET_NOT_FOUND("SRS-5000");

	private String code;

	private ErrorCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
