package com.bean;


public class RegisterBean {

private String firstName;
private String lastName;
private String fatherName;
private String email;
private int classStudent;
private int age;
private int SlNo;



public void setEmail(String email) {
this.email = email;
}
public String getEmail() {
return email;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFatherName() {
	return fatherName;
}
public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}
public int getClassStudent() {
	return classStudent;
}
public void setClassStudent(int classStudent) {
	this.classStudent = classStudent;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getSlNo() {
	return SlNo;
}
public void setSlNo(int slNo) {
	SlNo = slNo;
}
}