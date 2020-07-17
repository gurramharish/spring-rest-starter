package com.hans.srs.model;

import java.time.LocalDate;

public class UserResponse {

	private String name;
	private int age;
	private String mobileNumber;
	private String emailId;
	private LocalDate dob;

	public UserResponse() {
		super();
	}

	public UserResponse(String name, int age, String mobileNumber, String emailId) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}
	
	public UserResponse(String name, int age, String mobileNumber, String emailId, LocalDate dob) {
		this(name, age, mobileNumber, emailId);
		this.dob = dob;
	}


	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
