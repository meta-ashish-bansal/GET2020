package com.metacube.parkingSystem.service;

import java.util.List;

import com.metacube.parkingSystem.model.Employee;

public interface EmployeeService {
	
	public int addEmployee(Employee employee);
	
	public Employee checkLogin(String emailId, String password);
	
	public boolean updateEmployee(int employeeId, Employee employee);
	
	public List<Employee> getFriends(String organizationName, int employeeId);

	public Employee getEmployee(int employeeId);

}
