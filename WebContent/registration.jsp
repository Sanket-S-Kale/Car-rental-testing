<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Login Page</title>
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
  		<h2 class="text-white-50" style="">- Go beyond the horizon</h2>
	
		<form action="RegisterServlet" method="post">
		<fieldset style="margin-left: auto!important; margin-right:auto!important; width: 500px">
            <legend> Login </legend>
			<table>
				<tr>
						<td>
							Username
						</td>
						<td>
							<input type="text" class="form-control" name="username">
						</td>
					</tr>
					<tr>
						<td>
							Password
						</td>
						<td>
							<input type="text" class="form-control" name="password">
						</td>
					</tr>
					<tr>
						<td>
							UTA ID
						</td>
						<td>
							<input type="text" class="form-control" name="utaid">
						</td>
					</tr>
					<tr>
						<td>
							First Name
						</td>
						<td>
							<input type="text" class="form-control" name="firstname">
						</td>
					</tr>
					<tr>
						<td>
							Last Name
						</td>
						<td>
							<input type="text" class="form-control" name="lastname">
						</td>
					</tr>
					<tr>
						<td>
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
						<td>
							Date of Birth (mm/dd/yyyy)
						</td>
						<td>
							<input class="form-control" type="text" name="dob">
						</td>
					</tr>
					<tr>
						<td>
							Phone Number
						</td>
						<td>
							<input type="text" class="form-control" name="phonenumber">
						</td>
					</tr>
					<tr>
						<td>
							Email
						</td>
						<td>
							<input type="text" class="form-control" name="email">
						</td>
					</tr>
					<tr>
						<td>
							Driving License Number
						</td>
						<td>
							<input type="text" class="form-control" name="dl">
						</td>
					</tr>
					<tr>
						<td>
							Address
						</td>
						<td>
							<textarea type="text" class="form-control" name="address"></textarea>
						</td>
					</tr>
					<tr>
						<td><input class="btn" type="submit" value="register" /></td>
					</tr>
				</table>
			
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