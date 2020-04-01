package com.metacube.parkingSystem.utils;

import java.sql.*;

public class ConnectionUtility {

	private String driverPath = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/ParkingSystem";

	private String userName = "root";

	private String password = "123";


	public Connection createConnection() {

		Connection conn = null;
		try {
			Class.forName(driverPath);
			conn = DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return conn;
	}


	public boolean closeConnection(Connection connection) {
		boolean isConnectionClose = false;
		try {
			connection.close();
			isConnectionClose = true;
		}
		catch(Exception e) {

			e.printStackTrace();
		}

		return isConnectionClose;
	}



}
