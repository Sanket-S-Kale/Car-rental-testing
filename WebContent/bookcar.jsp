<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Reserve Car</title>
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
            <legend class="text-white-50"> Book a Car </legend>
			<table>
					<th class="text-white-50">Car Details</th>
					<tr>
						<td class="text-white-50">
							Car Name
						</td>
						<td>
							<text type="text" class="form-control" name="carname">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Capacity
						</td>
						<td>
							<text type="text" class="form-control" name="capacity">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							<p><input type="checkbox" name="gps" value="gps">GPS</p>
						</td>
						<td class="text-white-50">
							<p><input type="checkbox" name="onstar" value="onstar">OnStar</p>
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							<p><input type="checkbox" name="siriusxm" value="siriusxm">SiriusXM</p>
						</td>
						<td class="text-white-50">
							<p><input type="checkbox" name="clubmember" value="clubmember">Arlington auto club member</p>
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							<p>Pickup Date: <input style="margin-right:20px; " type="text" name="pickupdate" placeholder="YYYY/MM/DD"> <br> 
							Pickup Time: <input type="text" name="pickuptime" placeholder="HH:MM"> </p>
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							<p>Drop-off Date: <input style="margin-right:20px; " type="text" name="dropoffdate" placeholder="YYYY/MM/DD"> <br>
							 Drop-off Time: <input type="text" name="dropofftime" placeholder="HH:MM"></p>
						</td>
					</tr>
		</table>
		<table>
			<th class="text-white-50">Payment Details</th>
					<tr>
						<td class="text-white-50">
							Card Number
						</td>
						<td>
							<input type="text" class="form-control" name="cardnumber" placeholder="Enter card number here">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							CVV
						</td>
						<td>
							<input type="text" class="form-control" name="cvv" placeholder="3 digit CVV number">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Expiry Date
						</td>
						<td>
							<input class="form-control" type="text" name="month" placeholder="MM/YYYY">
						</td>
					</tr>	
				</table>
				<input style="margin-left:auto!important; margin-right:auto!important; margin-top:10px;" class="btn" type="submit" value="Book my car" />
			</fieldset>
		</form>
		<form action="userhome.jsp" method="post">
				<button type="submit" class="btn btn-link text-white-50">Go to Homepage!!</button>
		</form>
	</div>
	</div>
	</header>
</body>
</html>