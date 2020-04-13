package com.metacube.parkingSystem.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.metacube.parkingSystem.model.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Integer>{
	
	@Query("from Vehicle where employee_employeeId = :employeeId")
	Vehicle findVehicleByEmployeeId(@Param("employeeId") int employeeId);
	
	
}
