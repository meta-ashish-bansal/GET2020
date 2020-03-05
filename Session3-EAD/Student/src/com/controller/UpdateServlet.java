package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RegisterBean;

import com.dao.UpdateDao;

/**
 * Servlet implementation class UpdateServlet
 */

public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public UpdateServlet() {
	 }
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("serv called");
		int Id = Integer.parseInt(request.getParameter("SlNo"));
		String firstName = request.getParameter("firstname");
		 String lastName = request.getParameter("lastname");
		 String fatherName = request.getParameter("fathername");
		 String email = request.getParameter("email");
		 int classStudent = Integer.parseInt(request.getParameter("classstudent"));
		 int age = Integer.parseInt(request.getParameter("age"));
		 System.out.println(firstName);
		 System.out.println(lastName);
		 System.out.println(fatherName);
		 System.out.println(email);
		 System.out.println(classStudent);
		 System.out.println(age);
		 System.out.println(Id);
		 
		 RegisterBean registerBean = new RegisterBean();
		 //Using Java Beans - An easiest way to play with group of related data
		 registerBean.setFirstName(firstName);
		 registerBean.setLastName(lastName);
		 registerBean.setFatherName(fatherName);
		 registerBean.setEmail(email);
		 registerBean.setClassStudent(classStudent);
		 registerBean.setAge(age);
		 registerBean.setSlNo(Id);
		 System.out.println("hello world");
		 UpdateDao updateDao = new UpdateDao();
		 String userUpdated = updateDao.registerUser(registerBean);
		 
		 if(userUpdated.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userUpdated);
		 request.getRequestDispatcher("/Update.jsp").forward(request, response);
		 }
	}

}
