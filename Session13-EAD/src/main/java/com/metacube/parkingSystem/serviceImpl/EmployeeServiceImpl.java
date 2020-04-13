package com.metacube.parkingSystem.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.EmployeeDao;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public int addEmployee(Employee employee)  {

		if(checkLogin(employee.getEmail(), employee.getPassword()) != null) {
			return 0;
		}
		else {
			employeeDao.save(employee);
			return employee.getEmployeeId();
		}

	}


	@Transactional
	public Employee checkLogin(String emailId, String password) {

		Employee employee = null;
		try {
			employee =employeeDao.findEmployeeByEmailIdAndPassword(emailId, password);
			return employee;
		}
		catch (Exception e) {
			return employee;
		}
	}



	@Transactional
	public boolean updateEmployee(Employee employee) {

		try {
			employeeDao.save(employee);
			return true;
		}
		catch(Exception e) {
			return false;
		}

	}


	@Transactional
	public List<Employee> getFriends(String organizationName, int employeeId) {
		return employeeDao.findFriends(organizationName, employeeId);
	}

	@Transactional
	public Employee getEmployee(int employeeId) {

		return employeeDao.findById(employeeId).orElse(new Employee());
	}
}
