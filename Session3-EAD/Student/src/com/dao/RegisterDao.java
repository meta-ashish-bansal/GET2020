
package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bean.RegisterBean;
import com.util.DBConnection;
public class RegisterDao {
	public String registerUser(RegisterBean registerBean)
	{
		String firstName = registerBean.getFirstName();
		String lastName = registerBean.getLastName();
		String fatherName = registerBean.getFatherName();
		String email = registerBean.getEmail();
		int classStudent = registerBean.getClassStudent();
		int age = registerBean.getAge();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into users(SlNo,firstName,lastName,fatherName,Email,classStudent,age) values (NULL,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
			
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, fatherName);
			preparedStatement.setString(4, email);
			preparedStatement.setInt(5, classStudent);
			preparedStatement.setInt(6, age);
			
			int i= preparedStatement.executeUpdate();
			
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