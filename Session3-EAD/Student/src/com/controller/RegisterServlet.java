package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RegisterBean;
import com.dao.RegisterDao;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public RegisterServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Copying all the input parameters in to local variables
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String fatherName = request.getParameter("fathername");
		String email = request.getParameter("email");
		int classStudent = Integer.parseInt(request.getParameter("classstudent"));
		int age = Integer.parseInt(request.getParameter("age"));

		RegisterBean registerBean = new RegisterBean();

		registerBean.setFirstName(firstName);
		registerBean.setLastName(lastName);
		registerBean.setFatherName(fatherName);
		registerBean.setEmail(email);
		registerBean.setClassStudent(classStudent);
		registerBean.setAge(age);

		RegisterDao registerDao = new RegisterDao();

		//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		String userRegistered = registerDao.registerUser(registerBean);

		if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
		
		else   //On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
	}
}