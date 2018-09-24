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
  		<form action="loginServlet" method="post">
        <fieldset style="margin-left: auto!important; margin-right:auto!important; width: 300px">
            <legend> Login </legend>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="username" class="form-control" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userpass"  class="form-control" /></td>
                </tr>
                <tr>
                    <td><input type="submit" class="btn" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
    <form action="registration.jsp" method="post">
				<button type="submit" class="btn btn-link text-white-50">Click here to Register!!</button>
		</form>
  		</div>
  		
  		
  	</div>	
  </header>
</body>
</html>