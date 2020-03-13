package com.metacube.parkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingSystem.model.Pass;

public class PassMapper implements RowMapper<Pass>  {

	public Pass mapRow(ResultSet rs, int i) throws SQLException {
		Pass pass = new Pass();
		pass.setPassId(rs.getInt(1));
		pass.setPassValue(rs.getDouble(2));
		pass.setPassType(rs.getString(3));
		pass.setVehicleId(rs.getInt(4));
		return pass;
	}

}
