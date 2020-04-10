package com.metacube.parkingSystem.dao;

import com.metacube.parkingSystem.model.Vehicle;

public interface VehicleDao {
	
	public int addVehicle(Vehicle vehicle);
	
	public Vehicle getVehicle(int employeeId);
	
	public Vehicle getVehicleByVehicleId(int vehicleId);
	
	public boolean updateVehicle(Vehicle vehicle);

	
	
}
