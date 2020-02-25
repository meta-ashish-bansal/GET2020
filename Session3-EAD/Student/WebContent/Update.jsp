<pre><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="com.util.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
<script> 
function validate()
{ 
 var firstname = document.form.firstname.value;
 var lastname = document.form.lastname.value;
 var fathername = document.form.fathername.value;
 var email = document.form.email.value;
 var classstudent = document.form.classstudent.value; 
 var age = document.form.age.value;
 var conpassword= document.form.conpassword.value;
 

	if (firstname == null || firstname == "") {
			alert("First Name can't be blank");
			return false;
		}

		else if (lastname == null || lastname == "") {
			alert("Last Name can't be blank");
			return false;
		} else if (fathername == null || fathername == "") {
			alert("Father Name can't be blank");
			return false;
		} else if (email == null || email == "") {
			alert("Email can't be blank");
			return false;
		} else if (classstudent == null || classstudent == "") {
			alert("class of student can't be blank");
			return false;
		} else if (age == null || age == "") {
			alert("Age can't be blank");
			return false;
		}
	}
</script> 
</head>

<body>

<%
ResultSet resultSet = null;
Connection con = null;
PreparedStatement preparedStatement = null;
con = DBConnection.createConnection();
String id = request.getParameter("id");
String sql =String.format("SELECT * FROM users where SlNo = %s",id);

preparedStatement = con.prepareStatement(sql);
resultSet = preparedStatement.executeQuery(sql);
resultSet.next();
String firstName = resultSet.getString("firstName");
String lastName = resultSet.getString("lastName");
String fatherName = resultSet.getString("fatherName");
String Email = resultSet.getString("Email");
String classStudent = resultSet.getString("classStudent");
String age = resultSet.getString("age");
%>

<center><h2>Update details of Student</h2></center>
<form name="form" action="UpdateServlet" method="post" onsubmit="return validate()">
<table align="center">
 <tr>
 <td>Sno</td>
 <td><input type="text" value =<%=id %>  name="SlNo" /></td>
 </tr>
 <tr>
 <td>First Name</td>
 <td><input type="text" value =<%=firstName %>  name="firstname" /></td>
 </tr>
 <tr>
 <td>Last Name</td>
 <td><input type="text" value =<%=lastName %>  name="lastname" /></td>
 </tr>
 <tr>
 <td>Father Name</td>
 <td><input type="text" value =<%=fatherName %>  name="fathername" /></td>
 </tr>
 <tr>
 <td>Email</td>
 <td><input type="text" value =<%=Email %>  name="email" /></td>
 </tr>
 <tr>
 <td>Class</td>
 <td><input type="text" value =<%=age %>  name="classstudent" /></td>
 </tr>
 <tr>
 <td>Age</td>
 <td><input type="text" value =<%=classStudent %>  name="age" /></td>
 </tr>

 <tr>
 <td><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></td>
 </tr>
 <tr>
 <td></td>
 <td><input type="submit" value="Update"></input>
 </tr>
</table>
</form>
 
</body>
</html>