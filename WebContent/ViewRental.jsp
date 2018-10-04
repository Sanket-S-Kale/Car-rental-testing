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
              <a class="nav-link js-scroll-trigger">Check Car Availability</a>
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
    <h2 style="margin-top:20px;">Search Results</h2>
        <table class="table bg-white table-hover table-bordered" >
        <thead>
 		<tr>
  		<th>Reservation ID</th>
  		<th>Car Name</th>
  		<th>User Name</th>
  		<th>Start Date</th>
  		<th>Start Time</th>
  		<th>End Date</th>
  		<th>End Time</th>
  		<th>Action</th>
 		</tr>
 		</thead>
 		<tbody>
       <c:forEach var="var1" items='${requestScope["queryResults"]}'>
 <tr>  
     <td>   ${var1.reservation_id}</td>
       <td> ${var1.car_name}</td>
       <td> ${var1.user_name}</td>
     <td>   ${var1.start_date} </td>
   <td>     ${var1.start_time} </td>
   <td>     ${var1.close_date} </td>
    <td>     ${var1.close_time} </td>
    
    
    <td> 
       <form action="CancelBookingServlet" method="get">
       			<input type="hidden" name="reservation_id" value="${var1.reservation_id}" />
				<button type="submit" class="reservation_id" class="btn">Delete Rental</button>
		</form>
	</td>
     </tr> 
       
</c:forEach>
</tbody>
      </table>
</body>
</html>