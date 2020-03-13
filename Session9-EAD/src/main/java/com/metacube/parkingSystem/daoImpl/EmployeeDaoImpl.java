package com.metacube.parkingSystem.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.EmployeeDao;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.utils.ConnectionUtility;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	public int addEmployee(Employee employee) {
		int employeeId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {

			PreparedStatement ps  = connection.prepareStatement(insertEmployee);
			ps.setString(1, employee.getEmail());
			ps.setString(2, employee.getFullName());
			ps.setString(3,employee.getGender());
			ps.setString(4,employee.getPassword());
			ps.setString(5,employee.getContactNumber());
			ps.setString(6, employee.getOrganizationName());

			if(ps.executeUpdate() > 0) {
				PreparedStatement getEmpId = connection.prepareStatement(getEmployeeIdByEmail);
				getEmpId.setString(1, employee.getEmail());
				ResultSet rs = getEmpId.executeQuery();
				if(rs.next()) {
					employeeId = rs.getInt(1);
				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return employeeId;


	}


	public Employee checkLogin(String emailId, String password) {
		Employee employee = null;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(checkLogin);
			ps.setString(1, emailId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmail(rs.getString(2));
				employee.setFullName(rs.getString(3));
				employee.setGender(rs.getString(4));
				employee.setPassword(rs.getString(5));
				employee.setContactNumber(rs.getString(6));
				employee.setOrganizationName(rs.getString(7));
			}

			return employee;

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return employee;
	}


	public boolean updateEmployee(int employeeId, Employee employee) {
		boolean update = false;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(updateEmployee);
			ps.setString(1, employee.getEmail());
			ps.setString(2, employee.getFullName());
			ps.setString(3,employee.getGender());
			ps.setString(4,employee.getPassword());
			ps.setString(5,employee.getContactNumber());
			ps.setString(6, employee.getOrganizationName());
			ps.setInt(7, employeeId);

			if(ps.executeUpdate() > 0) {
				update = true;
			}


		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return update;
	}


	public List<Employee> getFriends(String organizationName, int employeeId) {
		List<Employee> friends = new ArrayList<Employee>();
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(selectFriends);
			ps.setString(1, organizationName);
			ps.setInt(2, employeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmail(rs.getString(2));
				employee.setFullName(rs.getString(3));
				employee.setGender(rs.getString(4));
				employee.setPassword(rs.getString(5));
				employee.setContactNumber(rs.getString(6));
				employee.setOrganizationName(rs.getString(7));
				friends.add(employee);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return friends;	

	}



	public Employee getEmployee(int employeeId) {
		Employee employee = null;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();

		try {
			PreparedStatement ps  = connection.prepareStatement(selectEmployee);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmail(rs.getString(2));
				employee.setFullName(rs.getString(3));
				employee.setGender(rs.getString(4));
				employee.setPassword(rs.getString(5));
				employee.setContactNumber(rs.getString(6));
				employee.setOrganizationName(rs.getString(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return employee;	

	}

}
