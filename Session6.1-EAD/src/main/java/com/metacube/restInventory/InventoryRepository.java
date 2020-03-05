package com.metacube.restInventory;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.sql.*;


public class InventoryRepository {

	public List<InventoryBean> getInventory() {
		List<InventoryBean> inventory = new ArrayList<>();
		try {
			Connection conn = DBConnection.initializeDatabase(); 
			java.sql.PreparedStatement st = conn.prepareStatement("select * from inventory");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				InventoryBean a = new InventoryBean();
				a.setName(rs.getString(1));
				a.setQuantity(rs.getInt(2));
				inventory.add(a);
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return inventory;
	}

	public InventoryBean getFruit(String name) {
		InventoryBean a = new InventoryBean();
		try {
			Connection conn = DBConnection.initializeDatabase();  
			java.sql.PreparedStatement st = conn.prepareStatement("select * from inventory where name=?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				a.setName(rs.getString(1));
				a.setQuantity(rs.getInt(2));
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return a;
	}

	public void createFruits(InventoryBean a1) {
		try {
			Connection conn = DBConnection.initializeDatabase(); 
			java.sql.PreparedStatement st = conn.prepareStatement("insert into inventory values(?,?)");
			st.setString(1, a1.getName());
			st.setInt(2, a1.getQuantity());
			st.executeUpdate();

		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateFruits(InventoryBean a1) {
		try {
			Connection conn = DBConnection.initializeDatabase();   
			java.sql.PreparedStatement st = conn.prepareStatement("update inventory set quantity=? where name=?");
			st.setString(2, a1.getName());
			st.setInt(1, a1.getQuantity());
			st.executeUpdate();

		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public void deleteFruits(String name) {
		try {
			Connection conn = DBConnection.initializeDatabase();  
			java.sql.PreparedStatement st = conn.prepareStatement("delete from inventory where name=?");
			st.setString(1, name);
			st.executeUpdate();

		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public void deleteAll() {
		try {
			Connection conn = DBConnection.initializeDatabase(); 
			java.sql.PreparedStatement st = conn.prepareStatement("delete from inventory");
			st.executeUpdate();
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
