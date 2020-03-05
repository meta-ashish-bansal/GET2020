<pre><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
<center><h2>Registration of Student</h2></center>
<form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
<table align="center">
 <tr>
 <td>First Name</td>
 <td><input type="text" name="firstname" /></td>
 </tr>
 <tr>
 <td>Last Name</td>
 <td><input type="text" name="lastname" /></td>
 </tr>
 <tr>
 <td>Father Name</td>
 <td><input type="text" name="fathername" /></td>
 </tr>
 <tr>
 <td>Email</td>
 <td><input type="text" name="email" /></td>
 </tr>
 <tr>
 <td>Class</td>
 <td><input type="text" name="classstudent" /></td>
 </tr>
 <tr>
 <td>Age</td>
 <td><input type="text" name="age" /></td>
 </tr>

 <tr>
 <td><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></td>
 </tr>
 <tr>
 <td></td>
 <td><input type="submit" value="Register"></input>
 </tr>
</table>
</form>
 
</body>
</html>