package com.metacube.parkingSystem.daoImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.PassDao;
import com.metacube.parkingSystem.mapper.PassMapper;
import com.metacube.parkingSystem.model.Pass;

@Repository
public class PassDaoImpl implements PassDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PassDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int addPass(Pass pass) {
		int passId = -1;
		int insertRow = jdbcTemplate.update(insertPass, pass.getPassValue(), pass.getPassType(), pass.getVehicleId());
		if(insertRow > 0) {

			return getPassId(pass.getVehicleId());
		}
		return passId;
	}

	public int getPassId(int vehicleId) {

		return jdbcTemplate.queryForObject(getPassIdByVehicleId, new Object[] { vehicleId }, Integer.class );
	}

	//	public int addPass(Pass pass) {
	//		int passId = -1;
	//		ConnectionUtility connectionUtility = new ConnectionUtility();
	//		Connection connection = connectionUtility.createConnection();
	//		try {
	//			PreparedStatement ps  = connection.prepareStatement(insertPass);
	//			ps.setDouble(1, pass.getPassValue());
	//			ps.setString(2, pass.getPassType());
	//			ps.setInt(3, pass.getVehicleId());
	//			if(ps.executeUpdate() > 0) {
	//
	//				PreparedStatement getPassId = connection.prepareStatement(getPassIdByVehicleId);
	//				getPassId.setInt(1, pass.getPassId());
	//				ResultSet rs = getPassId.executeQuery();
	//				if(rs.next()) {
	//					passId = rs.getInt(1);
	//				}
	//
	//			}
	//		}
	//		catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return passId;
	//
	//
	//
	//	}
	//

	public Pass getPass(int vehicleId) {
		Pass pass = null;
		pass = jdbcTemplate.queryForObject(getPassByVehicleId, new Object[] {vehicleId}, new PassMapper());
		return pass;
	}

	//	public Pass getPass(int vehicleId) {
	//		Pass pass = null;
	//		ConnectionUtility connectionUtility = new ConnectionUtility();
	//		Connection connection = connectionUtility.createConnection();
	//		try {
	//			PreparedStatement ps  = connection.prepareStatement(getPassByVehicleId);
	//			ps.setInt(1, vehicleId);
	//			ResultSet rs = ps.executeQuery();
	//			if(rs.next()) {
	//				pass = new Pass();
	//				pass.setPassId(rs.getInt(1));
	//				pass.setPassValue(rs.getDouble(2));
	//				pass.setPassType(rs.getString(3));
	//				pass.setVehicleId(rs.getInt(4));
	//
	//			}
	//		}
	//		catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return pass;
	//
	//	}


	public boolean updatePass(int passId, Pass pass) {
		boolean update = false;
		int affectedRow = jdbcTemplate.update(updatePass, pass.getPassValue(), pass.getPassType(), pass.getVehicleId(), passId);
		if(affectedRow > 0 ) {
			update = true;
		}
		return update;
	}

	//	public boolean updatePass(int passId, Pass pass) {
	//		boolean update = false;
	//		ConnectionUtility connectionUtility = new ConnectionUtility();
	//		Connection connection = connectionUtility.createConnection();
	//		try {
	//			PreparedStatement ps  = connection.prepareStatement(updatePass);
	//
	//
	//			ps.setDouble(1, pass.getPassValue());
	//			ps.setString(2, pass.getPassType());
	//			ps.setInt(3, pass.getVehicleId());
	//			ps.setInt(4, passId);
	//
	//			if(ps.executeUpdate() > 0) {
	//				update = true;
	//			}
	//
	//		}
	//		catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//
	//		return update;
	//
	//	}

}
