package com.metacube.parkingSystem.service;

import com.metacube.parkingSystem.model.Pass;

public interface PassService {
	
	public int addPass(Pass pass);
	
	public Pass getPass(int vehicleId);
	
	public boolean updatePass(int passId, Pass pass);
	



}
