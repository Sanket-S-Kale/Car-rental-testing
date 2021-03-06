<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
		<form action="CompleteBookingServlet" method="post">

		<form action="AddcarServlet" method="post">

		<fieldset style="margin-left: auto!important; margin-right:auto!important; width: 500px">
            <legend class="text-white-50"> Book a Car </legend>
			<table width="600px;">
			<c:forEach var="var1" items='${requestScope["queryResults"]}'>
					<th class="text-white-50">Car Details</th>
					<tr>
					    <td class="text-white-50">
							Car Id
						</td>
						<td class="text-white-50">
							<input type="text" name="car_id" value="${var1.car_id}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Car Name
						</td>
						<td class="text-white-50">
							<input type="text" name="car_name" value="${var1.car_name}">
							<%-- <p>${var1.car_name}</p> --%>
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Capacity
						</td>
						<td class="text-white-50">
							<input type="text" name="capacity" value="${var1.capacity}">
							<%-- <p>${var1.capacity}</p> --%>
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Pickup Date
						</td>
						<td>
							<input type="text" class="form-control" name="pickupdate" value="${var1.pickupdate}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							Pick Up Time
						</td>
						<td>
							<input type="text" class="form-control" name="pickuptime" value="${var1.pickuptime}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							End Date
						</td>
						<td>
							<input type="text" class="form-control" name="dropoffdate" value="${var1.dropoffdate}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							End Time
						</td>
						<td>
							<input type="text" class="form-control" name="dropofftime" value="${var1.dropofftime}">
						</td>
					</tr>
					
					<tr>
						<td class="text-white-50">
							Amount
						</td>
						<td>
							<input type="text" class="form-control" name="amount" value="${var1.amount}">
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							<p><input type="checkbox" name="gps" value="1" checked>GPS</p>
						</td>
						<td class="text-white-50">
							<p><input type="checkbox" name="onstar" value="1" checked>OnStar</p>
						</td>
					</tr>
					<tr>
						<td class="text-white-50">
							<p><input type="checkbox" name="siriusxm" value="1">SiriusXM</p>
						</td>
						<td class="text-white-50">
							<p><input type="checkbox" name="clubmember" value="1">Arlington auto club member</p>
						</td>
					</tr>
			</c:forEach>
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