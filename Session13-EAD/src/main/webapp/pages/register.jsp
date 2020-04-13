<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../includes/header.jsp"%>
<script src="../includes/passwordCheck.js"></script>


<div class="container form-container">
	<form:form modelAttribute="employee" action="/registerEmployee">
		<div class="form-group">
			<form:label path="fullName"></form:label>
			<form:input path="fullName" type="text" placeholder="Full Name"
				class="form-control" />
			<form:errors path="fullName" class="text-danger"></form:errors>
		</div>

		<div class="custom-control custom-radio">
			<form:radiobutton path="gender" id="male" value="male" />
			<form:label path="gender">Male</form:label>
		</div>
		<div class="custom-control custom-radio">
			<form:radiobutton path="gender" id="female" value="female" />
			<form:label path="gender">Female</form:label>
		</div>
		<div class="form-group">
			<form:label path="email"></form:label>
			<form:input path="email" type="email" placeholder="Email Id"
				class="form-control" />
			<form:errors path="email" class="text-danger"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="Password"></form:label>
			<form:input path="Password" type="password" placeholder="Password"
				class="form-control" />
			<form:errors path="Password" class="text-danger"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="confirmPassword"></form:label>
			<form:input path="confirmPassword" type="password"
				placeholder="Confirm Password" class="form-control" onkeyup="checkPassword()" />
			<form:errors path="confirmPassword" class="text-danger"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="contactNumber"></form:label>
			<form:input path="contactNumber" type="text"
				placeholder="Contact Number" class="form-control" />
			<form:errors path="contactNumber" class="text-danger"></form:errors>
		</div>
		<div class="form-group">
			<form:select class="custom-select" path="organizationName">
				<form:option value="Metacube">Metacube</form:option>
				<form:option value="Infosys">Infosys</form:option>
				<form:option value="Cognizant">Cognizant</form:option>
				<form:option value="TCS">TCS</form:option>
			</form:select>
			<form:errors path="organizationName" class="text-danger"></form:errors>
		</div>
		<form:button id="Submit" type="submit" class="btn btn-primary">Register</form:button>
	</form:form>
</div>

<%@ include file="../includes/footer.jsp"%>



