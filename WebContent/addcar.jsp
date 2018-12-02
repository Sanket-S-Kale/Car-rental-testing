<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Add new car page</title>
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
	
		<form action="AddcarServlet" method="post">
		<fieldset style="margin-left: auto!important; margin-right:auto!important; width: 500px">
            <legend class="text-white-50"> Add a new car </legend>
            <legend name="allFieldError" id="allFieldError" class="text-danger">${errorList.generalError}</legend>
			<table>
					<tr>
						<td class="text-white-50">
							Car Name
						</td>
						<td>
							<input type="text" class="form-control" name="carname">
						</td>
						<td style="color:red" class="text-danger">${errorList.carnameError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Capacity
						</td>
						<td>
							<input type="text" class="form-control" name="capacity">
						</td>
						<td class="text-danger">${errorList.capacityError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Weekday Rate
						</td>
						<td>
							<input type="text" class="form-control" name="weekdayrate">
						</td>
						<td class="text-danger">${errorList.weekdayError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Weekend Rate
						</td>
						<td>
							<input type="text" class="form-control" name="weekendrate">
						</td>
						<td class="text-danger">${errorList.weekendError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Weekly Rate
						</td>
						<td>
							<input type="text" class="form-control" name="weeklyrate">
						</td>
						<td class="text-danger">${errorList.weeklyError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							GPS Rate
						</td>
						<td>
							<input type="text" class="form-control" name="gpsrate">
						</td>
						<td class="text-danger">${errorList.gpsError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							OnStar Rate
						</td>
						<td>
							<input type="text" class="form-control" name="onstarrate">
						</td>
						<td class="text-danger">${errorList.onstarError }</td>
					</tr>
					<tr>
						<td class="text-white-50">
							SiriusXm Rate
						</td>
						<td>
							<input class="form-control" type="text" name="siriusxmrate">
						</td>
						<td class="text-danger">${errorList.siriusxmError }</td>
					</tr>	
				</table>
				<input style="margin-left:auto!important; margin-right:auto!important; margin-top:10px;" class="btn" type="submit" value="Add Car" />
			</fieldset>
		</form>
		<form action="rentalmanagerhome.jsp" method="post">
				<button type="submit" class="btn btn-link text-white-50">Go to Homepage!!</button>
		</form>
	</div>
	</div>
	</header>
</body>
</html>