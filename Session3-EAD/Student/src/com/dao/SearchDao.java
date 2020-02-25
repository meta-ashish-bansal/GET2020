/*package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

import com.bean.RegisterBean;
import com.util.DBConnection;

public class SearchDao extends HttpServlet{
	String firstName;
	String lastName;
	public  void registerUser(RegisterBean registerBean)
	{
		 firstName = registerBean.getFirstName();
		 lastName = registerBean.getLastName();

		Connection con = null;
		Statement stmt = null;
	}
	
	try
		{
			con = DBConnection.createConnection();
			stmt = con.createStatement();
			String query = String.format("SELECT * FROM StudentBase where firstName='%s' AND lastName='%s'", firstName,lastName);
			ResultSet result = stmt.executeQuery(query);
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			out.println("<body>");
			out.println("<div class=\"outerBox\">");
			out.println("<table border=\"1px\">");
			out.println("<tr><th>SN</th><th>FirstName</th><th>LastName</th><th>FatherName</th><th>Email</th><th>Class</th><th>Age</th><th>Update</th></tr>");
			while (result.next()) {
				out.println("<tr><td>" + result.getString("id") + "</td><td>"
						+ result.getString("firstName") + "</td><td>"
						+ result.getString("lastName") + "</td><td>"
						+ result.getString("fathername") + "</td><td>"
						+ result.getString("email") + "</td><td>"
						+ result.getString("class") + "</td><td>"
						+ result.getString("age")
						+ "</td><td><a href=\"UpdateStudentDetail.jsp?id="+ result.getString("id") +"\">update</a></td></tr>");
			}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}*/
