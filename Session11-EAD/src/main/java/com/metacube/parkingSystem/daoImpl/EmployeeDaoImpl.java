package com.metacube.parkingSystem.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.EmployeeDao;
import com.metacube.parkingSystem.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public int addEmployee(Employee employee) {
		int employeeId = -1;
		Session session = entityManager.unwrap(Session.class);
		if(checkLogin(employee.getEmail(),employee.getPassword()) == null) {
			session.save(employee);
			employeeId = employee.getEmployeeId();
			return employeeId;
		}
		else {
			return 0;
		}

	}

	public Employee checkLogin(String emailId, String password) { 
		Employee employee = null;
		Session session = entityManager.unwrap(Session.class);
		try {
			Query<Employee> query = session.createQuery("from Employee where emailId = :emailId and password = :password", Employee.class);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			employee = query.getSingleResult();
			return employee;
		}
		catch(Exception e) {
			return employee;
		}
	}

	public boolean updateEmployee(Employee employee) {
		boolean update = false;
		Session session = entityManager.unwrap(Session.class);
		try {
			
			session.update(employee);
			update = true;
			return update;
		}
		catch(Exception e) {
			return update;
		}

	}

	public List<Employee> getFriends(String organizationName, int employeeId) {
		List<Employee> friends = new ArrayList<Employee>();
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee Where Organization_Name = :organizationName and EmployeeId <> :employeeId", Employee.class);
		query.setParameter("organizationName", organizationName);
		query.setParameter("employeeId", employeeId);
		friends = query.getResultList();
		return friends;

	}

	public Employee getEmployee(int employeeId) {
		Employee employee = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			Query<Employee> query = session.createQuery("from Employee where EmployeeId = :employeeId", Employee.class);
			query.setParameter("employeeId", employeeId);
			employee = query.getSingleResult();
			return employee;
		}
		catch(Exception e) {
			return employee;
		}
	}




}
