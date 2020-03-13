package com.metacube.parkingSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.EmployeeDao;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public int addEmployee(Employee employee)  {
		return employeeDao.addEmployee(employee);
	}

	public Employee checkLogin(String emailId, String password) {
		return employeeDao.checkLogin(emailId, password);
	}

	public boolean updateEmployee(int employeeId, Employee employee) {
		return employeeDao.updateEmployee(employeeId, employee);
	}

	public List<Employee> getFriends(String organizationName, int employeeId) {
		return employeeDao.getFriends(organizationName, employeeId);
	}

	public Employee getEmployee(int employeeId) {
		return employeeDao.getEmployee(employeeId);
	}
}
