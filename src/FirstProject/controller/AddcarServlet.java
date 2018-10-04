package FirstProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car_Rental_Util.sqlconnector;
import FirstProject.model.RegisterErrors;
import FirstProject.model.addCarError;
import Car_Rental_Util.sqlconnector;
import java.util.Random;
import java.util.regex.Pattern;

public class AddcarServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String carname = request.getParameter("carname");
  String capacity = request.getParameter("capacity");
  String weekdayrate = request.getParameter("weekdayrate");
  String weekendrate = request.getParameter("weekendrate");
  String weeklyrate = request.getParameter("weeklyrate");
  String gpsrate = request.getParameter("gpsrate");
  String onstarrate = request.getParameter("onstarrate");
  String siriusxmrate = request.getParameter("siriusxmrate");
  
  addCarError ae = new addCarError();
  boolean hasErrors = false;
  
  ///////////////////               Validate given inputs                  ////////////////////
  Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
  Pattern hasUppercase = Pattern.compile("[A-Z]");
  Pattern hasLowercase = Pattern.compile("[a-z]");
  Pattern hasNumber = Pattern.compile("\\d");
  Pattern hasSpecialChar = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
  Pattern dofb = Pattern.compile("^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/(1[0-9][0-9][0-9]|2[0-9][0-9][0-9])$");
  Pattern mail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
  Pattern dollar = Pattern.compile("^[0-9]+\\.[0-9][0-9]");
  int capacityv = Integer.parseInt(capacity);

  ///////////////////               Validation for isRequired:              ////////////////////
  
  if (carname.isEmpty() || capacity.isEmpty() || weekdayrate.isEmpty() || weekendrate.isEmpty() || gpsrate.isEmpty() || onstarrate.isEmpty()|| siriusxmrate.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("addcar.jsp");
   out.println("<font color=red>Please fill all the fields</font>");
   rd.include(request, response);
  } 
  
  //////////////////               Validation for Car Name:                /////////////////////
  
  else if (hasSpecialChar.matcher(carname).find()) {
	  ae.carnameError = "Must be alphanumeric Only. ";
	  hasErrors = true;
  }
  // Since car_id is PK in database, Car Name need not be unique //
  
  /////////////////               Validation for Capacity                  /////////////////////
  
  else if (!capacity.matches("[0-9]+")){
	  ae.capacityError = "Must Contain Number Only";
	  hasErrors = true;
	 
  }
  
  	else if (capacityv > 25){
  	ae.capacityError = "Maximum Capacity is 25";
  	hasErrors = true;
	 
 }
  
  /////////////////              Validation for Weekday Rate:          //////////////////////////
  
  else if (!dollar.matcher(weekdayrate).find()) {
	  ae.weekdayError = "Use Valid Currency Format";
	  hasErrors = true;
	 
  }
  
  /////////////////              Validation for Weekend Rate:          ///////////////////////////
  
  else if (!dollar.matcher(weekendrate).find()) {
	  ae.weekendError = "Use Valid Currency Format";
	  hasErrors = true;
  }
  
 //////////////////             Validation for Weekly Rate:             /////////////////////////
  
  else if (!dollar.matcher(weeklyrate).find()) {
	  ae.weeklyError = "Use Valid Currency Format";
	  hasErrors = true;
  }
  
  /////////////////             Validation for GPS Rate:               ///////////////////////////
  
  else if (!dollar.matcher(gpsrate).find()) {
	  ae.gpsError = "Use Valid Currency Format";
	  hasErrors = true;
  }
  
  ////////////////              Validation for OnStar Rate:             ////////////////////////
  
  else if (!dollar.matcher(onstarrate).find()) {
	  ae.onstarError = "Use Valid Currency Format";
	  hasErrors = true;
  }
  
  ////////////////             Validation for SiriusXM Rate:              ///////////////////////
  
  else if (!dollar.matcher(siriusxmrate).find()) {
	  ae.siriusxmError = "Use Valid Currency Format";
	  hasErrors = true;
  }
  
  if(hasErrors == true){
	  RequestDispatcher rd20 = request.getRequestDispatcher("addcar.jsp");
	  request.setAttribute("errorList",ae);
	   rd20.forward(request, response);
  }
  
  else {
	  Connection conn = null;
      PreparedStatement pst = null;
      ResultSet rs = null;

   // inserting data into mysql database 
   // create a test database and student table before running this to create table
   //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
   try {
	   	
	   
	   	   int random = (int )(Math.random() * 100 + 20);
           conn = sqlconnector.connect();
           
           pst = conn
                   .prepareStatement("insert into cars (car_name,capacity,weekday_rate,weekend_rate,weekly_rate,gps_rate,onstar_rate,siriusXM_rate) values(?,?,?,?,?,?,?,?)");
//           	pst.setInt(1, null);
			pst.setString(1, carname);
			pst.setInt(2, Integer.parseInt(capacity));
			pst.setDouble(3, Double.parseDouble(weekdayrate));
			pst.setDouble(4, Double.parseDouble(weekendrate));
			pst.setDouble(5, Double.parseDouble(weeklyrate));
			pst.setDouble(6, Double.parseDouble(gpsrate));
			pst.setDouble(7, Double.parseDouble(onstarrate));
			pst.setDouble(8, Double.parseDouble(siriusxmrate));
			
			pst.executeUpdate(); // execute it on test database
			System.out.println("Successfuly added new car");
			
			conn.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("addcar.jsp");
			out.print("<p style=\"color:red\">Car added successfully</p>");
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
   

 
