package com.metacube.parkingSystem.service;

import com.metacube.parkingSystem.model.Vehicle;

public interface VehicleService {

	public int addVehicle(Vehicle vehicle);
	
	public Vehicle getVehicle(int employeeId) ;
	
	public boolean updateVehicle(Vehicle vehicle);
	
	public Vehicle getVehicleByVehicleId(int vehicleId);

}
