<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../includes/loginHeader.jsp"%>
<script src="../includes/passwordCheck.js"></script>

<div class="container">
	<div class="jumbotron text-center text-primary">Personal Details
	</div>
</div>

<div class="container form-container">
	<img id="user_image" src="${imagePath}" alt="Profile image">
	<form action="uploadImage" method="post" enctype="multipart/form-data">
		<div class="custom-file">
			<input type="file" name="image" class="custom-file-input"
				id="validatedCustomFile"> <label class="custom-file-label"
				for="validatedCustomFile">Choose file...</label>
		</div>
		<br> <br> <input type="submit" value="Upload Image"
			class="btn btn-primary">
	</form>
	<form:form modelAttribute="employee" action="/editEmployee">


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
		<div class="text-center text-successs alert alert-primary">
			<p>EmailID : ${employee.email}</p>
		</div>
		<form:hidden path="email" class="form-control" />
		<div class="form-group">
			<form:label path="Password"></form:label>
			<form:input path="Password" type="text" placeholder="Password"
				class="form-control" id="password" />
			<form:errors path="Password" class="text-danger"></form:errors>
		</div>
		<form:hidden path="confirmPassword" value="123" class="form-control" />

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
		<form:button type="submit" id="Submit" class="btn btn-primary">Edit</form:button>
	</form:form>
</div>

<%@ include file="../includes/footer.jsp"%>
