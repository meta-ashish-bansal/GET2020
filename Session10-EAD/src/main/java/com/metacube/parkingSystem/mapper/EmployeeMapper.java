package com.metacube.parkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingSystem.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setEmployeeId(resultSet.getInt(1));
		employee.setEmail(resultSet.getString(2));
		employee.setFullName(resultSet.getString(3));
		employee.setGender(resultSet.getString(4));
		employee.setPassword(resultSet.getString(5));
		employee.setContactNumber(resultSet.getString(6));
		employee.setOrganizationName(resultSet.getString(7));
		return employee;

	}

}

