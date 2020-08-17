package com.hans.srs.model.codeset;

public class CodeValueRequest {

	private String name;
	private String value;
	private String description;
	private String codeSetName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCodeSetName() {
		return codeSetName;
	}

	public void setCodeSetName(String codeSetName) {
		this.codeSetName = codeSetName;
	}

}
