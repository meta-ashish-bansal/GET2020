package com.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.RegisterBean;
import com.util.DBConnection;
public class UpdateDao {
	public String registerUser(RegisterBean registerBean)
	{
		int Id = registerBean.getSlNo();
		String firstName = registerBean.getFirstName();
		String lastName = registerBean.getLastName();
		String fatherName = registerBean.getFatherName();
		String email = registerBean.getEmail();
		int classStudent = registerBean.getClassStudent();
		int age = registerBean.getAge();
		Connection con = null;
		Statement stmt = null;

		try
		{
			con = DBConnection.createConnection();
			stmt = con.createStatement();
			String query = String.format("UPDATE users SET firstName='%s',lastName='%s' , fatherName='%s', Email='%s',classStudent=%d,age=%d WHERE SlNo=%d",firstName,lastName,fatherName, email, classStudent, age,Id);

			int i= stmt.executeUpdate(query);
			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
}