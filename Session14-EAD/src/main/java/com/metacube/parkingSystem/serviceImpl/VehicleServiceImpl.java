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
		vehicleDao.save(vehicle);
		return vehicle.getVehicleId();
	}


	@Transactional
	public Vehicle getVehicle(int employeeId) {
		return vehicleDao.findVehicleByEmployeeId(employeeId);
	}


	@Transactional
	public boolean updateVehicle(Vehicle vehicle) {
		try {
			vehicleDao.save(vehicle);
			return true;
		}
		catch(Exception e) {
			return false;
		}

	}


	@Transactional
	public Vehicle getVehicleByVehicleId(int vehicleId) {
		return vehicleDao.findById(vehicleId).orElse(new Vehicle());
	}

}
