<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Login Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./style.css">
	
	<title>User Homepage</title>
</head>
<body>
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
              <a class="nav-link js-scroll-trigger" href="userhome.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="CheckReserveRentalServlet">Request Rental</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="ViewRentalServlet">View Rentals</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger">Delete Rental</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="EditProfileServlet">Update Profile</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <header class="masthead1" style="height:100vh; padding:0;">
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
  		</div>
  		</div>
  	</header>
</body>
</html>