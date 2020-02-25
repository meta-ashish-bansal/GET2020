<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Page</title>
<script> 
function validate()
{ 
 var firstname = document.form.firstname.value;
 var lastname = document.form.lastname.value;
 

	if (firstname == null || firstname == "") {
			alert("First Name can't be blank");
			return false;
		}

		else if (lastname == null || lastname == "") {
			alert("Last Name can't be blank");
			return false;
		} 
	}
</script> 
</head>
<body>
<center><h2>Search Student</h2></center>
<form name="form" action="SearchServlet" method="post" onsubmit="return validate()">
<table align="center">
 <tr>
 <td>Name</td>
 <td><input type="text" name="name" /></td>
 </tr>
 <tr>
<!-- <td>Last Name</td>
 <td><input type="text" name="lastname" /></td> --> 
 <tr>
 <td>Class</td>
 <td><input type="text" name="classstudent" /></td>
 </tr>
 </tr>
 

 <tr>
 <td><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></td>
 </tr>
 <tr>
 <td></td>
 <td><input type="submit" value="Search"></input>
 </tr>
</table>
</form>
 
</body>
</html>