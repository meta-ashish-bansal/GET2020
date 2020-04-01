<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.MetacubeParkingSystem.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%
	if (session.getAttribute("userId") != null) {
		String site = new String("HomePage.jsp");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="index.css" rel="stylesheet">
</head>
<body>
	<div class="box">
		<div class="employeeDetail">
			<div class="boxTitle">
				<h1>Sign In</h1>
			</div>
			<div class="boxContent">
				<form action="SignIn" method="post" >
					
					<fieldset id="emailField">
						<legend>&nbsp; Email&nbsp; </legend>
						<input id="email" type="email" placeholder="Enter Email....."
							name="email" required>
					</fieldset>
					<fieldset id="passwordField">
						<legend> &nbsp;Password&nbsp; </legend>
						<input id="password" type="password"
							placeholder="Enter Password....." name="password" required>
					</fieldset>
					<input type="submit" name="submit">

					<!-- <button onclick="checkValidation()">Next</button> -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>