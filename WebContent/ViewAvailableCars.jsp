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
    <h2>AVAILABLE CARS</h2>
    <h3>
        Hello,
        <%=session.getAttribute("name")%>  below are the cars available for your search parameters :- </h3>
        
        <table style=" background-color: white" >
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
  		<th> Action</th>
 		</tr>
       <c:forEach var="var1" items='${requestScope["queryResults"]}'>
 <tr>  
     <td>   ${var1.car_id}</td>
       <td> ${var1.car_name}</td>
       <td> ${var1.capacity}</td>
     <td>   ${var1.weekday_rate} </td>
   <td>     ${var1.weekend_rate} </td>
   <td>     ${var1.weekly_rate} </td>
    <td>     ${var1.gps_rate} </td>
    <td>     ${var1.onstar_rate} </td>
    <td>     ${var1.sirusXM_rate} </td>
    
    
    <td> 
       <form action="BookCarRentalServlet" method="get">
       			<input type="hidden" name="car_id" value="${var1.car_id}" />
				<button type="submit" class="car_id" >Book Car!!</button>
		</form>
	</td>
     </tr> 
       
</c:forEach>
      </table>
</body>
</html>