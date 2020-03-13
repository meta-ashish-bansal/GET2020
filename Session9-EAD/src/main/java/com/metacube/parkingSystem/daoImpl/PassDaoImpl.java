package com.metacube.parkingSystem.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.PassDao;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.utils.ConnectionUtility;

@Repository
public class PassDaoImpl implements PassDao {

	public int addPass(Pass pass) {
		int passId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(insertPass);
			ps.setDouble(1, pass.getPassValue());
			ps.setString(2, pass.getPassType());
			ps.setInt(3, pass.getVehicleId());
			if(ps.executeUpdate() > 0) {

				PreparedStatement getPassId = connection.prepareStatement(getPassIdByVehicleId);
				getPassId.setInt(1, pass.getPassId());
				ResultSet rs = getPassId.executeQuery();
				if(rs.next()) {
					passId = rs.getInt(1);
				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return passId;



	}



	public Pass getPass(int vehicleId) {
		Pass pass = null;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(getPassByVehicleId);
			ps.setInt(1, vehicleId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pass = new Pass();
				pass.setPassId(rs.getInt(1));
				pass.setPassValue(rs.getDouble(2));
				pass.setPassType(rs.getString(3));
				pass.setVehicleId(rs.getInt(4));

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return pass;

	}


	public boolean updatePass(int passId, Pass pass) {
		boolean update = false;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement(updatePass);


			ps.setDouble(1, pass.getPassValue());
			ps.setString(2, pass.getPassType());
			ps.setInt(3, pass.getVehicleId());
			ps.setInt(4, passId);

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
