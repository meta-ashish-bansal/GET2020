package com.metacube.parkingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metacube.parkingSystem.model.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>{

	@Query("from Employee where emailId = :emailId and password = :password")
	Employee findEmployeeByEmailIdAndPassword(@Param("emailId") String emailId, @Param("password") String password);

	@Query("from Employee where Organization_Name = :organizationName and EmployeeID <> :employeeId")
	List<Employee> findFriends(@Param("organizationName") String organizationName, @Param("employeeId") int employeeId);

}
