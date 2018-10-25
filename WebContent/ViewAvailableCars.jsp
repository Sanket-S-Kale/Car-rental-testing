<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head >
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./style.css">
</head>
<body class="masthead" style="height:100vh; padding:0;">
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="LogoutServlet">Logout</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="rentalmanagerhome.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger">Car Calendar</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="RequestRental.jsp">Check Car Availability</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="SearchRental.jsp">Search Rental</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="EditProfileServlet">Update Profile</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="addcar.jsp">Add Car</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <h2 style="margin-top:20px;">AVAILABLE CARS</h2>
    <h3>
        Hello,
        <%=session.getAttribute("name")%>  below are the cars available for your search parameters :- </h3>
        
        <table class="table table-stripeds" style=" background-color: white" >
 		<tr>
  		<th>Car ID</th>
  		<th>Car Name</th>
  		<th>Capacity</th>
  		<th>Weekday Rate</th>
  		<th>Weekend Rate</th>
  		<th>Weekly Rate</th>
  		<th>Gps Rate</th>
  		<th>Onstar Rate</th>
  		<th>SiriusXM Rate</th>
  		<th>PickUpDate</th>
  		<th>DropOffDate</th>
  		<th>Amount($)</th>
  		<th> Action</th>
 		</tr>
       <c:forEach var="var1" items='${requestScope["queryResults"]}'>

 <tr>  
     <td>${var1.car_id}</td>
     <td>${var1.car_name}</td>
     <td>${var1.capacity}</td>
     <td>${var1.weekday_rate}</td>
	 <td>${var1.weekend_rate}</td>
  	 <td>${var1.weekly_rate}</td>
     <td>${var1.gps_rate}</td>
     <td>${var1.onstar_rate}</td>
     <td>${var1.sirusXM_rate}</td>
     <td><input type="text" name="pickupdate" value="${var1.pickupdate}" /></td>
     <td><input type="text" name="dropoffdate" value="${var1.dropoffdate}" /></td>
     <td><input type="text" name="amount" value="${var1.amount}" /></td>
    <td> 
       <form action="BookCarRentalServlet" method="get">
       			<input type="hidden" name="car_id" value="${var1.car_id}" />
       			<input type="hidden" name="pickupdate" value="${var1.pickupdate}" />
       			<input type="hidden" name="dropoffdate" value="${var1.dropoffdate}" />
       			<input type="hidden" name="amount1" value="${var1.amount}" />
				<button class="btn btn-primary btn-sm" type="submit" class="car_id" >Book Car!!</button>
		</form>
	</td>
     </tr> 
  
       
</c:forEach>
      </table>
</body>
</html>