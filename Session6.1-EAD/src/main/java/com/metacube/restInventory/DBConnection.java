package com.metacube.restInventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DBConnection 
{
			protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
			String dbDriver = "com.mysql.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/inventorydb"; 
	        String dbUsername = "root"; 
	        String dbPassword = "root";
	        Class.forName(dbDriver);
	        Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
	        return conn;
		}
	
}
