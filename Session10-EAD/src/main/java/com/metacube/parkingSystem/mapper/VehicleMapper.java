package com.metacube.parkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingSystem.model.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle> {

	public Vehicle mapRow(ResultSet rs, int i) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(rs.getInt(1));
		vehicle.setVehicleNumber(rs.getString(2));
		vehicle.setVehicleName(rs.getString(3));
		vehicle.setVehicleType(rs.getString(4));
		vehicle.setVehicleIdentification((rs.getString(5)));
		vehicle.setEmployeeId(rs.getInt(6));
		return vehicle;
	}

}
