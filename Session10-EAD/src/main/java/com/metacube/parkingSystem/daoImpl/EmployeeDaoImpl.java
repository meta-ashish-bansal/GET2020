package com.metacube.parkingSystem.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.EmployeeDao;
import com.metacube.parkingSystem.mapper.EmployeeMapper;
import com.metacube.parkingSystem.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addEmployee(Employee employee) {
		int employeeId = -1;
		if(getEmployeeId(employee.getEmail()) != 0 ) {
			return 0;
		}
		else {
			int insertRow = jdbcTemplate.update(insertEmployee, employee.getEmail(), employee.getFullName(), employee.getGender(), employee.getPassword(), employee.getContactNumber(), employee.getOrganizationName());
			if(insertRow > 0) {

				return getEmployeeId(employee.getEmail());

			}
			return employeeId;
		}
	}
	public int getEmployeeId(String emailId) {

		try {
			return jdbcTemplate.queryForObject(getEmployeeIdByEmail, new Object[] { emailId }, Integer.class );
		}
		catch(Exception e) {
			return 0;
		}
	}


	public Employee checkLogin(String emailId, String password) { 

		return jdbcTemplate.queryForObject(checkLogin, new Object[] { emailId, password}, new EmployeeMapper());
	}


	public boolean updateEmployee(int employeeId, Employee employee) {
		boolean update = false;
		int affectedRow = jdbcTemplate.update(updateEmployee, employee.getFullName(), employee.getGender(), employee.getPassword(), employee.getContactNumber(), employee.getOrganizationName(), employeeId);

		if(affectedRow > 0) {
			update = true;
		}
		System.out.println("edit dao");
		System.out.println(update );
		return update;
	}


	//	public boolean updateEmployee(int employeeId, Employee employee) {
	//		boolean update = false;
	//		ConnectionUtility connectionUtility = new ConnectionUtility();
	//		Connection connection = connectionUtility.createConnection();
	//		try {
	//			PreparedStatement ps  = connection.prepareStatement(updateEmployee);
	//			ps.setString(1, employee.getEmail());
	//			ps.setString(2, employee.getFullName());
	//			ps.setString(3,employee.getGender());
	//			ps.setString(4,employee.getPassword());
	//			ps.setString(5,employee.getContactNumber());
	//			ps.setString(6, employee.getOrganizationName());
	//			ps.setInt(7, employeeId);
	//
	//			if(ps.executeUpdate() > 0) {
	//				update = true;
	//			}
	//
	//
	//		}
	//		catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return update;
	//	}

	public List<Employee> getFriends(String organizationName, int employeeId) {
		List<Employee> friends = new ArrayList<Employee>();

		friends = jdbcTemplate.query(selectFriends,new Object[] {organizationName, employeeId}, new EmployeeMapper());
		return friends;
	}

	//	public List<Employee> getFriends(String organizationName, int employeeId) {
	//		List<Employee> friends = new ArrayList<Employee>();
	//		ConnectionUtility connectionUtility = new ConnectionUtility();
	//		Connection connection = connectionUtility.createConnection();
	//		try {
	//			PreparedStatement ps  = connection.prepareStatement(selectFriends);
	//			ps.setString(1, organizationName);
	//			ps.setInt(2, employeeId);
	//			ResultSet rs = ps.executeQuery();
	//			while(rs.next()) {
	//				Employee employee = new Employee();
	//				employee.setEmployeeId(rs.getInt(1));
	//				employee.setEmail(rs.getString(2));
	//				employee.setFullName(rs.getString(3));
	//				employee.setGender(rs.getString(4));
	//				employee.setPassword(rs.getString(5));
	//				employee.setContactNumber(rs.getString(6));
	//				employee.setOrganizationName(rs.getString(7));
	//				friends.add(employee);
	//			}
	//		}
	//		catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return friends;	
	//
	//	}
	//
	//

	public Employee getEmployee(int employeeId) {
		Employee employee = null;
		employee = jdbcTemplate.queryForObject(selectEmployee, new Object[] { employeeId }, new EmployeeMapper());
		return employee;
	}

	//	public Employee getEmployee(int employeeId) {
	//		Employee employee = null;
	//		ConnectionUtility connectionUtility = new ConnectionUtility();
	//		Connection connection = connectionUtility.createConnection();
	//
	//		try {
	//			PreparedStatement ps  = connection.prepareStatement(selectEmployee);
	//			ps.setInt(1, employeeId);
	//			ResultSet rs = ps.executeQuery();
	//			while(rs.next()) {
	//				employee = new Employee();
	//				employee.setEmployeeId(rs.getInt(1));
	//				employee.setEmail(rs.getString(2));
	//				employee.setFullName(rs.getString(3));
	//				employee.setGender(rs.getString(4));
	//				employee.setPassword(rs.getString(5));
	//				employee.setContactNumber(rs.getString(6));
	//				employee.setOrganizationName(rs.getString(7));
	//			}
	//		}
	//		catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return employee;	
	//
	//	}

}
