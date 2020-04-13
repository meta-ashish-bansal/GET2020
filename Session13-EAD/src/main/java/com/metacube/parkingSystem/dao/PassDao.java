package com.metacube.parkingSystem.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metacube.parkingSystem.model.Pass;

public interface PassDao extends CrudRepository<Pass, Integer> {

	@Query("from Pass where vehicle_vehicleId = :vehicleId")
	Pass findPassByVehicleId(@Param("vehicleId") int vehicleId);



}
