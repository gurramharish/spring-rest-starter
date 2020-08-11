package com.hans.srs.model;

public class SRSResponse {

	private SRSStatus status;
	private String description;
	
	public SRSResponse(SRSStatus status, String description) {
		this.status = status;
		this.description = description;
	}

	public SRSStatus getStatus() {
		return status;
	}

	public void setStatus(SRSStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
