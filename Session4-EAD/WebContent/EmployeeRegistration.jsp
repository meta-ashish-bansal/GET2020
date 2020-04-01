

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
				<h1>Employee Detail</h1>
			</div>
			<div class="boxContent">
				<form action="EmployeeRegistration" method="post">
					<fieldset id="nameField">
						<legend>&nbsp; Name&nbsp; </legend>
						<input id="name" type="text" placeholder="Enter Name....."
							name="name" required>
					</fieldset>
					<fieldset id="emailField">
						<legend>&nbsp; Email&nbsp; </legend>
						<input id="email" type="email" placeholder="Enter Email....."
							name="email" required>
					</fieldset>
					<fieldset id="mobileField">
						<legend>&nbsp; Mobile &nbsp;</legend>
						<input id="mobile" type="number" placeholder="Enter Mobile....."
							name="mobile" required>
					</fieldset>
					<fieldset id="passwordField">
						<legend> &nbsp;Password&nbsp; </legend>
						<input id="password" type="password"
							placeholder="Enter Password....." name="password" required>
					</fieldset>
					<fieldset id="rePasswordField">
						<legend> &nbsp;Re Password&nbsp; </legend>
						<input id="rePassword" type="password"
							placeholder=" Re Enter Password....." name="rePassword" required>
					</fieldset>
					<fieldset>
						<legend> &nbsp;Gender&nbsp; </legend>
						<input type="radio" id="male" value="Male" name="gender" checked>
						<label for="male">Male</label> <input type="radio" id="female"
							value="Female" name="gender"> <label for="female">Female</label>
					</fieldset>
					<fieldset>
						<legend> &nbsp;Organization&nbsp; </legend>
						<input  list="organizationName" type="text" name="organization" required>

						<datalist id="organizationName">
							<option value="Metacube">
							<option value="In TIme Tech">
							<option value="Google">
							<option value="Facebook">
							<option value="Linkedin">
						</datalist>
					
					</fieldset>
					<input type="submit" name="submit">

					<!-- <button onclick="checkValidation()">Next</button> -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>