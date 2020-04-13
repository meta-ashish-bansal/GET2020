<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../includes/header.jsp"%>
<form action="/login" method="post">
	<div class="form-group">
		<div class="alert alert-primary text-center" role="alert">
			${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
		<label for="username">User Name</label> <input type="text"
			class="form-control" name="username" id="username"
			placeholder="User Name">

	</div>
	<div class="form-group">
		<label for="password">Password</label> <input type="password"
			class="form-control" name="password" id="pasword"
			placeholder="Password">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>


<%@ include file="../includes/footer.jsp"%>
