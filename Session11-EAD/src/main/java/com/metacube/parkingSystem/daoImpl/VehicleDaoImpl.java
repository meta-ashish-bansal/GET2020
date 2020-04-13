package com.metacube.parkingSystem.daoImpl;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.VehicleDao;
import com.metacube.parkingSystem.model.Vehicle;
@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private EntityManager entityManager;


	@Override
	public int addVehicle(Vehicle vehicle) {
		int vehicleId = -1;
		Session session = entityManager.unwrap(Session.class);
		session.save(vehicle);
		vehicleId = vehicle.getVehicleId();
		return vehicleId;
	}



	public Vehicle getVehicle(int employeeId) {
		Vehicle vehicle = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			Query<Vehicle> query = session.createQuery("from Vehicle where employee_EmployeeID= :employeeId", Vehicle.class);
			query.setParameter("employeeId", employeeId);
			vehicle = query.getSingleResult();
			return vehicle;
		}
		catch(Exception e) {
			return vehicle;
		}
	}


	public Vehicle getVehicleByVehicleId(int vehicleId) {
		Vehicle vehicle = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			Query<Vehicle> query = session.createQuery("from Vehicle where VehicleID= :vehicleId", Vehicle.class);
			query.setParameter("vehicleId", vehicleId);
			vehicle = query.getSingleResult();
			return vehicle;
		}
		catch(Exception e) {
			return vehicle;
		}
	}


	public boolean updateVehicle(Vehicle vehicle) {
		boolean update = false;
		Session session = entityManager.unwrap(Session.class);
		try {
			System.out.println("before"+vehicle);
			session.clear();
			session.update(vehicle);
			System.out.println("after"+vehicle);
			update = true;
			return update;
		}
		catch(Exception e) {
			e.printStackTrace();
			return update;
		}

	}








}