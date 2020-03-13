<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../includes/header.jsp"%>

<div class="container form-container">
	<form:form modelAttribute="vehicle" action="/registerVehicle">
		<form:hidden path="employeeId" value="${employeeId}"
			class="form-control" />
		<div class="form-group">
			<form:label path="vehicleName"></form:label>
			<form:input path="vehicleName" type="text" placeholder="Vehicle Name"
				class="form-control" />
			<form:errors path="vehicleName" class="text-danger"></form:errors>
		</div>
		<div class="form-group">
			<form:select class="custom-select" path="vehicleType">
				<form:option value="cycle">Cycle</form:option>
				<form:option value="motorcycle">Motorcycle</form:option>
				<form:option value="fourWheelers">Four Wheelers</form:option>
			</form:select>
			<form:errors path="vehicleType" class="text-danger"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="vehicleNumber"></form:label>
			<form:input path="vehicleNumber" type="text"
				placeholder="Vehicle Number" class="form-control" />
			<form:errors path="vehicleNumber" class="text-danger"></form:errors>
		</div>
		<div class="text-center text-successs alert alert-primary">
			<p>EmployeeId : ${employeeId}</p>
		</div>
		<div class="form-group">
			<form:label path="vehicleIdentification"></form:label>
			<form:textarea path="vehicleIdentification"
				placeholder="Vehicle Identification" class="form-control" />
			<form:errors path="vehicleIdentification" class="text-danger"></form:errors>
		</div>
		<form:button type="submit" class="btn btn-primary">Register</form:button>
	</form:form>
</div>
<%@ include file="../includes/footer.jsp"%>
