package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import com.dao.SearchDao;*/
import com.util.DBConnection;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		//String lastName = request.getParameter("lastname");
		int classStudent = Integer.parseInt(request.getParameter("classstudent"));
		System.out.println(name);
		 
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			con = DBConnection.createConnection();
			stmt = con.createStatement();
			System.out.println(name);
			String query = String.format("SELECT * FROM users where (firstName='%s' OR lastName='%s' OR (LOWER(CONCAT(users.firstName,' ',users.lastName)) LIKE '%s')) AND classStudent ='%d'", name,name,name, classStudent);
			System.out.println(name);
			ResultSet result = stmt.executeQuery(query);
			System.out.println(name);
			PrintWriter out = response.getWriter();
			
			System.out.println(name);
			out.println("<html>");
			out.println("<body>");
			out.println("<div class=\"outerBox\">");
			out.println("<table border=\"1px\">");
			
			out.println("<tr><th>SlNo</th><th>FirstName</th><th>LastName</th><th>FatherName</th><th>Email</th><th>Class</th><th>Age</th><th>Update</th></tr>");
			while (result.next()) {
				out.println("<tr><td>" + result.getString("SlNo") + "</td><td>"
						+ result.getString("firstName") + "</td><td>"
						+ result.getString("lastName") + "</td><td>"
						+ result.getString("fathername") + "</td><td>"
						+ result.getString("email") + "</td><td>"
						+ result.getString("classStudent") + "</td><td>"
						+ result.getString("age")
						+ "</td><td><a href=\"UpdateStudentDetail.jsp?id="+ result.getString("Slno") +"\">update</a></td></tr>");
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

}
