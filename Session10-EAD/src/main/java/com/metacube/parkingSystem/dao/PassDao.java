package com.metacube.parkingSystem.dao;

import com.metacube.parkingSystem.model.Pass;

public interface PassDao {

	String insertPass = "INSERT INTO Pass values (PassID, ?, ?, ?)";
	String getPassIdByVehicleId = "Select PassId from Pass Where VehicleId = ?";
	String getPassByVehicleId = "Select * from Pass Where VehicleId = ?";
	String updatePass = "UPDATE Pass set PassValue = ?, PassType = ?, VehicleId = ? where PassId = ?";

	public int addPass(Pass pass);

	public Pass getPass(int vehicleId);
	
	public boolean updatePass(int passId, Pass pass);
	


}
