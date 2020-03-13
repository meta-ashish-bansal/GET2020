package com.metacube.parkingSystem.dao;

import java.util.List;

import com.metacube.parkingSystem.model.Employee;

public interface EmployeeDao {

	String insertEmployee = "INSERT INTO Employee VALUES (EmployeeId, ?, ?, ?, ?, ?, ?)" ;
	String updateEmployee = "UPDATE Employee set fullName = ?, gender = ?, Password = ?, ContactNumber = ?, OrganizationName = ? where EmployeeID = ?";
	String selectEmployee = "SELECT * FROM Employee where EmployeeId = ?";

	String checkLogin = "Select * from Employee where EmailID = ? and Password = ?";
    
	String getEmployeeIdByEmail = "SELECT EmployeeId from Employee where emailId = ?;";
	
	//String selectOrgName = "SELECT organizationName from Employee where EmployeeId = ?";
	String selectFriends = "SELECT * FROM Employee where organizationName = ? and EmployeeId <> ?;";

	public int addEmployee(Employee employee);

	public Employee checkLogin(String emailId, String password);

	public boolean updateEmployee(int employeeId, Employee employee);
	
	public List<Employee> getFriends(String organizationName, int employeeId);
	
	public Employee getEmployee(int employeeId);


	//public String getOrganizationName(int employeeId);

	//public List<Employee> getEmployees();

}
