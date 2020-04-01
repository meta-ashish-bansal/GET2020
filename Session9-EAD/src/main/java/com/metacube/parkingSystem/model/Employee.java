package com.metacube.parkingSystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Employee {

	private int employeeId;

	@NotBlank(message="Please enter full name") 
	private String fullName;

	@NotBlank(message="Please enter Email")  
	@Email(message="Please enter valid email")
	private String email;


	@NotBlank(message="Please enter gender")
	private	String gender;

	@NotBlank(message="Please enter password")
	private	String Password;

	@NotBlank(message="Please enter confirm password")
	private	String confirmPassword;

	@NotBlank(message="Please enter contact number")
	private String contactNumber;

	@NotBlank(message="Please enter Organization name") 
	private String organizationName;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}



}
