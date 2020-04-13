package com.metacube.parkingSystem.employeeCredential;

import javax.validation.constraints.NotBlank;

public class EmployeeCredential {

	@NotBlank
	private String emailId;

	@NotBlank
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
