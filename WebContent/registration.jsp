<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Registration Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./style.css">
	
</head>
<body>
	<header class="masthead" style="height:100vh; padding:0;">
  	<div class="container" style="height: 100% !important;
    display: flex;
    align-items: center;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;">
  		<div class="text-center" style="margin-left: auto!important; margin-right: auto!important;">
  		<h1>Go Mav Car Rental</h1>
  		<h2 class="text-white-50" style="font-style: italic;">- Go beyond the horizon</h2>
	
		<form action="RegisterServlet" method="post">
		<fieldset style="margin-left: auto!important; margin-right:auto!important; width: 500px">
            <legend class="text-white-50"> Register </legend>
			<table>
				<tr>
						<td class="text-white-50">
							Username
						</td>
						<td>
							<input type="text" class="form-control" name="username">
						</td>
						<td class="text-danger">${errorList.usernameError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Password
						</td>
						<td>
							<input type="text" class="form-control" name="password">
						</td>
						<td class="text-danger">${errorList.passwordError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							UTA ID
						</td>
						<td>
							<input type="text" class="form-control" name="utaid">
						</td>
						<td class="text-danger">${errorList.uidError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							First Name
						</td>
						<td>
							<input type="text" class="form-control" name="firstname">
						</td>
						<td class="text-danger">${errorList.fnameError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Last Name
						</td>
						<td>
							<input type="text" class="form-control" name="lastname">
						</td>
						<td class="text-danger">${errorList.lnameError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Role
						</td>
						<td>
							<select class="form-control" name="role"id="role">
							    <option value="Select Role" selected>Select Role</option>
								<option value="Admin">Admin</option>
								<option value="Rental Manager">Rental Manager</option>
								<option value="User">User</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Date of Birth (mm/dd/yyyy)
						</td>
						<td>
							<input class="form-control" type="text" name="dob">
						</td>
						<td class="text-danger">${errorList.dobError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Phone Number
						</td>
						<td>
							<input type="text" class="form-control" name="phonenumber">
						</td>
						<td class="text-danger">${errorList.phoneError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Email
						</td>
						<td>
							<input type="text" class="form-control" name="email">
						</td>
						<td class="text-danger">${errorList.emailError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Driving License Number
						</td>
						<td>
							<input type="text" class="form-control" name="dl">
						</td>
						<td class="text-danger">${errorList.dlError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Address
						</td>
						<td>
							<textarea type="text" class="form-control" name="address"></textarea>
						</td>
						<td class="text-danger">${errorList.addressError }</td>
					</tr>	
				</table>
				<input style="margin-left:auto!important; margin-right:auto!important; margin-top:5px;" class="btn btn-sm" type="submit" value="register" />
			</fieldset>
		</form>
		<form action="index.jsp" method="post">
				<button type="submit" class="btn btn-link text-white-50">Click here to Login!!</button>
		</form>
	</div>
	</div>
	</header>
</body>
</html>