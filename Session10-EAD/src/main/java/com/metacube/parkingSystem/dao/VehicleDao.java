package com.metacube.parkingSystem.dao;

import com.metacube.parkingSystem.model.Vehicle;

public interface VehicleDao {

	String insertVehicle = "INSERT INTO Vehicle values (VehicleID, ?, ?, ?, ?, ?)";
	String selectVehicle = "SELECT * FROM Vehicle where EmployeeId = ?";
	String selectVehicleByVehicleId = "SELECT * FROM Vehicle where Id = ?";
	String getVehicleIdByEmployeeId = "Select VehicleId from Vehicle where EmployeeId = ?";
	String updateVehicle = "UPDATE Vehicle SET VehicleNumber = ?, VehicleName = ?, VehicleType = ?, VehicleIdentification = ? where VehicleId =?";
	
	public int addVehicle(Vehicle vehicle);
	
	public Vehicle getVehicle(int employeeId);
	
	public boolean updateVehicle(int vehicleId, Vehicle vehicle);

	
	
}
