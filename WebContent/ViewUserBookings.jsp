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
    <h2>Booking Report for user</h2>
    <h3>
        Hello,
        <%=session.getAttribute("name")%>  below are bookings done by you :- </h3>
        
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
				<button type="submit" class="reservation_id" >Cancel Booking!!</button>
		</form>
	</td>
     </tr> 
       
</c:forEach>
</tbody>
      </table>
</body>
</html>