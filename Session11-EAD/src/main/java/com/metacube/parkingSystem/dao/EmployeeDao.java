package com.metacube.parkingSystem.dao;

import java.util.List;

import com.metacube.parkingSystem.model.Employee;

public interface EmployeeDao {


	public int addEmployee(Employee employee);

	public Employee checkLogin(String emailId, String password);

	public boolean updateEmployee(Employee employee);
	
	public List<Employee> getFriends(String organizationName, int employeeId);
	
	public Employee getEmployee(int employeeId);

}
