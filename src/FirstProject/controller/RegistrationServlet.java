package FirstProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car_Rental_Util.sqlconnector;
import Car_Rental_Util.sqlconnector;

public class RegistrationServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String userName = request.getParameter("username");
  String password = request.getParameter("password");
  String utaid = request.getParameter("utaid");
  String role = request.getParameter("role");
  String firstname = request.getParameter("firstname");
  String lastname = request.getParameter("lastname");
  String dob = request.getParameter("dob");
  String phonenumber = request.getParameter("phonenumber");
  String email = request.getParameter("email");
  String dl = request.getParameter("dl");
  String address = request.getParameter("address");

  
  
/////////////////                           validate given input            /////////////////////////
  
Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
Pattern hasUppercase = Pattern.compile("[A-Z]");
Pattern hasLowercase = Pattern.compile("[a-z]");
Pattern hasNumber = Pattern.compile("\\d");
Pattern hasSpecialChar = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
Pattern dofb = Pattern.compile("^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/(1[0-9][0-9][0-9]|2[0-9][0-9][0-9])$");
Pattern mail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

///////////////////                         Validation for isRequired      ////////////////////////
if (userName.isEmpty() || password.isEmpty() || utaid.isEmpty() || role.isEmpty() || dob.isEmpty() || phonenumber.isEmpty()|| email.isEmpty()|| dl.isEmpty()|| address.isEmpty()) {
RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Please fill all the fields</font>");
rd.include(request, response);
}


///////                       Validation for userName:               ///////////////////


if (!pattern.matcher(userName).matches()){
RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>No Special Characters in Username</font>");
rd.include(request, response);
}
if (userName.length() <= 5){
RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Username must have Minimum of 5 Characters</font>");
rd.include(request, response);

}
if (userName.length() >=16){
RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Username must have Maximum of 16 Characters</font>");
rd.include(request, response);
}
///////              Validation for Password:         ////////////////////

if (password.length() < 6){
RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Password must have Minimum of 6 Characters</font>");
rd.include(request, response);

}
if (!hasUppercase.matcher(password).find()) {
RequestDispatcher rd5 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Password must have at least one Upper Case Character </font>");
rd5.include(request, response);
}
if (!hasLowercase.matcher(password).find()) {
RequestDispatcher rd6 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Password must have at least one Lower Case Character </font>");
rd6.include(request, response);
}
if (!hasNumber.matcher(password).find()) {
RequestDispatcher rd7 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Password must have at least one Number </font>");
rd7.include(request, response);
}
if (!hasSpecialChar.matcher(password).find()) {
RequestDispatcher rd8 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Password must have at least one Special Character </font>");
rd8.include(request, response);
}
//////////////////            Validation for UTA ID:           ///////////////////

if (utaid.length() != 10){
RequestDispatcher rd9 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>UTA ID has to be 10 digits only. </font>");
rd9.include(request, response);

}
if (!utaid.matches("[0-9]+")){
RequestDispatcher rd10 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>UTA ID has to be Numeric Only. </font>");
rd10.include(request, response);

}

/////////////                      Validation for Name:               ///////////////////

if (!firstname.matches("[A-Za-z]+")){
RequestDispatcher rd11 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>First Name Has to contain alphabets only.. </font>");
rd11.include(request, response);

}

if (!lastname.matches("[A-Za-z]+")){
RequestDispatcher rd12 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Last Name Has to contain alphabets only.. </font>");
rd12.include(request, response);

}

//////////////                    Validation for DOB:                /////////////////////

if (!dofb.matcher(dob).matches()){
RequestDispatcher rd13 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Not a Valid Date Format</font>");
rd13.include(request, response);
}
////////////////////////////////////////////////////////(Incomplete)///////////////////

///////////                       Validation of Phone Number:       ///////////////////////
if (phonenumber.length() != 10){
RequestDispatcher rd14 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Phone Number has to be 10 digits only. </font>");
rd14.include(request, response);

}
if (!phonenumber.matches("[0-9]+")){
RequestDispatcher rd15 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Phone Number has to be Numeric Only. </font>");
rd15.include(request, response);

}

///////////////                  Validation for E-mail:         //////////////////////////

if (!mail.matcher(email).matches()){
RequestDispatcher rd16 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Invalid e-mail format</font>");
rd16.include(request, response);
}

//////////////                   Validation for Drivers License      /////////////////////

if (dl.length() != 8){
RequestDispatcher rd17 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Drivers Licesnse has to be 8 digits only. </font>");
rd17.include(request, response);

}
if (!dl.matches("[0-9]+")){
RequestDispatcher rd18 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Drivers License has to be Numeric Only. </font>");
rd18.include(request, response);

}

//////////////                 Validation for Address                /////////////////////

if (address.length() < 10){
RequestDispatcher rd19 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Address must have Minimum of 10 Characters</font>");
rd19.include(request, response);

}
if (address.length() >=100){
RequestDispatcher rd20 = request.getRequestDispatcher("registration.jsp");
out.println("<font color=red>Address must have Maximum of 100 Characters</font>");
rd20.include(request, response);
} else {
	  Connection conn = null;
      PreparedStatement pst = null;
      ResultSet rs = null;

   // inserting data into mysql database 
   // create a test database and student table before running this to create table
   //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
   try {
	   
	   	   conn=sqlconnector.connect();

           pst = conn.prepareStatement("select role_id from roles where role_name = ?");
           pst.setString(1, role);
           
           ResultSet roleResult = pst.executeQuery();
           int roleId = 0;
           while (roleResult.next())
        	   roleId = roleResult.getInt(1);
           System.out.println(roleId);
           pst.close();
           
           pst = conn
                   .prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?,?,'0')");
  

			pst.setString(1, userName);
			pst.setString(2, password);
			pst.setString(3, utaid);
			pst.setString(4, firstname);
			pst.setString(5, lastname);
			pst.setString(6, dob);
			pst.setString(7, phonenumber);
			pst.setString(8, email);
			pst.setString(9, address);
			pst.setString(10, dl);
			
			pst.executeUpdate(); // execute it on test database
			System.out.println("successfuly inserted user");
			
			
			pst.close();
			
			pst = conn.prepareStatement("insert into user_roles values(?,?)");
			pst.setInt(1, roleId);
			pst.setString(2, userName);
			pst.executeUpdate(); // execute it on test database
			System.out.println("successfuly inserted user role");
			
			pst.close();
			conn.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			out.print("<p style=\"color:red\">Record Successfully added</p>");
            rd.include(request,response); 
       }
       catch (Exception e) {
           System.out.println(e);
       } finally {
           if (conn != null) {
               try {
                   conn.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (pst != null) {
               try {
                   pst.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (rs != null) {
               try {
                   rs.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }   
       } 
   }
  }
 }
   

 
