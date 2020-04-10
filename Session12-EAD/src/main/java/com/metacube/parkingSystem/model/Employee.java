package com.metacube.parkingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name="EmployeeID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	@NotBlank(message="Please enter full name") 
	@Column(name="FullName")
	private String fullName;

	@NotBlank(message="Please enter Email")  
	@Email(message="Please enter valid email")
	@Column(name="EmailID")
	private String email;


	@NotBlank(message="Please enter gender")
	@Column(name="Gender")
	private	String gender;

	@NotBlank(message="Please enter password")
	@Column(name="Password")
	private	String Password;

	@Transient
	private	String confirmPassword;

	@NotBlank(message="Please enter contact number")
	@Pattern(regexp = "^[0-9]{10}$", message = "Please enter contact number correctly")
	@Column(name="ContactNumber")
	private String contactNumber;

	@NotBlank(message="Please enter Organization name")
	@Column(name="OrganizationName")
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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", fullName=" + fullName + ", email=" + email + ", gender="
				+ gender + ", Password=" + Password + ", confirmPassword=" + confirmPassword + ", contactNumber="
				+ contactNumber + ", organizationName=" + organizationName + "]";
	}



}
