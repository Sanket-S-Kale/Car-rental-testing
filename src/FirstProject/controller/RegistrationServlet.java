package FirstProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import FirstProject.model.RegisterErrors;

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
  
  Pattern pattern = Pattern.compile("[A-Za-z0-9_-]+");
  Pattern hasUppercase = Pattern.compile("[A-Z]");
  Pattern hasLowercase = Pattern.compile("[a-z]");
  Pattern hasNumber = Pattern.compile("\\d");
  Pattern hasSpecialChar = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
  Pattern dofb = Pattern.compile("^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/(1[0-9][0-9][0-9]|2[0-9][0-9][0-9])$");
  Pattern mail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
  RegisterErrors re = new RegisterErrors();
  boolean hasErrors = false;
  ///////////////////                         Validation for isRequired      ////////////////////////
  if (userName.isEmpty() || password.isEmpty() || utaid.isEmpty() || role.isEmpty() || dob.isEmpty() || phonenumber.isEmpty()|| email.isEmpty()|| dl.isEmpty()|| address.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
   out.println("<font color=red>Please fill all the fields</font>");
   rd.include(request, response);
  }
   
   
///////                       Validation for userName:               ///////////////////
   
   
  else if (!pattern.matcher(userName).matches()){
		  re.usernameError = "Must be alphanumeric and can contain only _ and - ";
		  hasErrors = true;
	  }
	  else if (userName.length() <= 5){
		  re.usernameError = "Must be greatar than 5 char";
		  hasErrors = true;
	  }
	  else if (userName.length() >=16){
		  re.usernameError = "Must be less than 16 char";
		  hasErrors = true;
	  }
	  ///////              Validation for Password:         ////////////////////
	  
	  else if (password.length() < 6){
		  re.passwordError = "Must be greater than 6 char";
		  hasErrors = true;
		  
	  }
	  else if (!hasUppercase.matcher(password).find()) {
		  re.passwordError = "Must have at least One Upper Case";
		  hasErrors = true;
	  }
	  else if (!hasLowercase.matcher(password).find()) {
		  re.passwordError = "Must have at least One Lower Case";
		  hasErrors = true;
	  }
	  else if (!hasNumber.matcher(password).find()) {
		  re.passwordError = "Must have at least One Number";
		  hasErrors = true;
	  }
	  else if (!hasSpecialChar.matcher(password).find()) {
		  re.passwordError = "Must have at least One Special Character";
		  hasErrors = true;
	  }
	  //////////////////            Validation for UTA ID:           ///////////////////
	  
	  else if (utaid.length() != 10){
		  re.uidError = "Must be a 10 Digit Number Only";
		  hasErrors = true;
		  
	  }
	  else if (!utaid.matches("[0-9]+")){
		  re.uidError = "Must be a 10 Digit Number Only";
		  hasErrors = true;
		  
	  }
	  
	  /////////////                      Validation for Name:               ///////////////////
	  
	  else if (!firstname.matches("[A-Za-z]+")){
		  re.fnameError = "Must contain Alphabets Only";
		  hasErrors = true;
		  
	  }
	  
	  else if (!lastname.matches("[A-Za-z]+")){
		  re.lnameError = "Must contain Alphabets Only";
		  hasErrors = true;
		  
	  }
	  
	  //////////////                    Validation for DOB:                /////////////////////
	  
	  else if (!dofb.matcher(dob).matches()){
		  re.dobError = "Must be Valid Date Format";
		  hasErrors = true;
	  }
	  ////////////////////////////////////////////////////////(Incomplete)///////////////////
	  
	  ///////////                       Validation of Phone Number:       ///////////////////////
	  else if (phonenumber.length() != 10){
		  re.phoneError = "Must be 10 Digits in Length";
		  hasErrors = true;
		  
	  }
	  else if (!phonenumber.matches("[0-9]+")){
		  re.phoneError = "Must conatin Numbers Only";
		  hasErrors = true;
	  }
	  
	  ///////////////                  Validation for E-mail:         //////////////////////////
	  
	  else if (!mail.matcher(email).matches()){
		  re.emailError = "Must be valid e-mail format";
		  hasErrors = true;
	  }
	  
	  //////////////                   Validation for Drivers License      /////////////////////
	  
	  else if (dl.length() != 8){
		  re.dlError = "Must be 8 digits in length";
		  hasErrors = true;
		  
	  }
	  else if (!dl.matches("[0-9]+")){
		  re.dlError = "Must be Numeric Only";
		  hasErrors = true;
	  }
	  
	  //////////////                 Validation for Address                /////////////////////
	  
	  else if (address.length() < 10){
		  re.addressError = "Must Contain Minimum 10 Characters";
		  hasErrors = true;
		  
	  }
	  else if (address.length() >=100){
		  re.addressError = "Must Contain Less Than 100 Characters";
		  hasErrors = true;
	  }
	  
	  if(hasErrors == true){
		  RequestDispatcher rd20 = request.getRequestDispatcher("registration.jsp");
		  request.setAttribute("errorList",re);
		   rd20.forward(request, response);
	  }
 
	  
  else {
	  
	  ///////////////////////////////////////////////////////////////////////
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
 


 
