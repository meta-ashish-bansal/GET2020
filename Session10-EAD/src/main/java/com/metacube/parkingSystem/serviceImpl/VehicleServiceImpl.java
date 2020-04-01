package com.metacube.parkingSystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.VehicleDao;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	public int addVehicle(Vehicle vehicle)  {
		return vehicleDao.addVehicle(vehicle);
	}


	public Vehicle getVehicle(int employeeId) {
		return vehicleDao.getVehicle(employeeId);
	}

	public boolean updateVehicle(int vehicleId, Vehicle vehicle) {
		return vehicleDao.updateVehicle(vehicleId, vehicle);
	}

}
