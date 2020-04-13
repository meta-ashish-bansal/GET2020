package com.metacube.parkingSystem.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.VehicleDao;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	@Transactional
	public int addVehicle(Vehicle vehicle)  {
		return vehicleDao.addVehicle(vehicle);
	}


	@Transactional
	public Vehicle getVehicle(int employeeId) {
		return vehicleDao.getVehicle(employeeId);
	}

	@Transactional
	public boolean updateVehicle(Vehicle vehicle) {
		return vehicleDao.updateVehicle(vehicle);
	}

	@Transactional
	public Vehicle getVehicleByVehicleId(int vehicleId) {
		return vehicleDao.getVehicleByVehicleId(vehicleId);
	}

}
