package com.metacube.parkingSystem.dao;

import com.metacube.parkingSystem.model.Pass;

public interface PassDao {


	public int addPass(Pass pass);

	public Pass getPass(int vehicleId);
	
	public boolean updatePass(Pass pass);
	


}
