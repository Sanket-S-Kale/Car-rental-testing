<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Edit Profile Details</title>
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
	
		<form action="UpdateProfileServlet" method="post">
		<fieldset style="margin-left: auto!important; margin-right:auto!important; width: 500px">
            <legend class="text-white-50"> Edit Profile Details </legend>
            
			<table>
			<c:forEach var="var1" items='${requestScope["queryResults"]}'>
				<tr>
						<td class="text-white-50">
							Username
						</td>
						<td>
							<input type="text" class="form-control" name="username" value="${var1.user_name}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Password
						</td>
						<td>
							<input type="text" class="form-control" name="password" value="${var1.usr_password}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							UTA ID
						</td>
						<td>
							<input type="text" class="form-control" name="utaid" value="${var1.uta_id}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							First Name
						</td>
						<td>
							<input type="text" class="form-control" name="firstname" value="${var1.first_name}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Last Name
						</td>
						<td>
							<input type="text" class="form-control" name="lastname" value="${var1.last_name}">
						</td>
					</tr>
					
					<tr>
						<td class="text-white-50">
							Date of Birth (mm/dd/yyyy)
						</td>
						<td>
							<input class="form-control" type="text" name="dob" value="${var1.date_of_birth}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Phone Number
						</td>
						<td>
							<input type="text" class="form-control" name="phonenumber" value="${var1.phone_number}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Email
						</td>
						<td>
							<input type="text" class="form-control" name="email" value="${var1.email}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Driving License Number
						</td>
						<td>
							<input type="text" class="form-control" name="dl" value="${var1.driving_license_number}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Address
						</td>
						<td>
							<input type="text" class="form-control" name="address" value="${var1.address}">
						</td>
					</tr>
					</c:forEach>	
				</table>
				
				<input style="margin-left:auto!important; margin-right:auto!important; margin-top:10px;" class="btn" type="submit" value="Update Profile" />
			</fieldset>
		</form>
		<form action="index.jsp" method="post">
				<button type="submit" class="btn btn-link text-white-50">Click here to login!!</button>
		</form>
	</div>
	</div>
	</header>
</body>
</html>