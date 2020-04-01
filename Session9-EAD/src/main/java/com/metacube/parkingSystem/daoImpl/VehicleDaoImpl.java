package com.metacube.parkingSystem.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.VehicleDao;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.utils.ConnectionUtility;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	public int addVehicle(Vehicle vehicle) {
		int vehicleId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(insertVehicle);
			ps.setString(1, vehicle.getVehicleNumber());
			ps.setString(2, vehicle.getVehicleName());
			ps.setString(3, vehicle.getVehicleType());
			ps.setString(4, vehicle.getVehicleIdentification());
			ps.setInt(5, vehicle.getEmployeeId());

			if(ps.executeUpdate() > 0) {
				PreparedStatement getVehicleId = connection.prepareStatement(getVehicleIdByEmployeeId);
				getVehicleId.setInt(1, vehicle.getEmployeeId());
				ResultSet rs = getVehicleId.executeQuery();
				if(rs.next()) {
					vehicleId = rs.getInt(1);
				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return vehicleId;


	}

	public Vehicle getVehicle(int employeeId) {
		Vehicle vehicle = null;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(selectVehicle);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vehicle = new Vehicle();
				vehicle.setVehicleId(rs.getInt(1));
				vehicle.setVehicleNumber(rs.getString(2));
				vehicle.setVehicleName(rs.getString(3));
				vehicle.setVehicleType(rs.getString(4));
				vehicle.setVehicleIdentification((rs.getString(5)));
				vehicle.setEmployeeId(rs.getInt(6));
			}		

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return vehicle;
	}



	public boolean updateVehicle(int vehicleId, Vehicle vehicle) {
		boolean update = false;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(updateVehicle);
			ps.setString(1, vehicle.getVehicleNumber());
			ps.setString(2, vehicle.getVehicleName());
			ps.setString(3, vehicle.getVehicleType());
			ps.setString(4, vehicle.getVehicleIdentification());
			ps.setInt(5, vehicleId);

			if(ps.executeUpdate() > 0) {
				update = true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}


		return update;

	}

}