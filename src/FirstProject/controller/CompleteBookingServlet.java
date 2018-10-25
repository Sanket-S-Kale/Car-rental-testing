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
import FirstProject.model.LoginDAO;
import Car_Rental_Util.sqlconnector;

public class CompleteBookingServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 static String temp;
	 
 @SuppressWarnings("resource")
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  String username=(String) request.getSession().getAttribute("name");
  PrintWriter out = response.getWriter();
  String has_gps = request.getParameter("gps");
  String has_on_star = request.getParameter("onstar");
  String has_sirius_xm = request.getParameter("siriusxm");
  String is_arlington_club_member = request.getParameter("clubmember");
  String start_date = request.getParameter("pickupdate");
  String start_time = request.getParameter("pickuptime");
  String end_date = request.getParameter("dropoffdate");
  String end_time = request.getParameter("dropofftime");
  String car_id = request.getParameter("car_id");
  String car_name = request.getParameter("car_name");
  String capacity = request.getParameter("capacity");
  String user_name=(String) request.getSession().getAttribute("name");
  PreparedStatement qry = null;
  ResultSet qrs = null;

  // validate given input
  if (start_time.isEmpty()|| end_date.isEmpty()|| end_time.isEmpty()|| car_id.isEmpty()|| car_name.isEmpty()|| capacity.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("CompleteBooking.jsp");
   out.println("<font color=red>Please fill all the fields</font>");
   rd.include(request, response);
  } else {
	  Connection conn = null;
      PreparedStatement pst = null;
      ResultSet rs = null;

   // inserting data into mysql database 
   // create a test database and student table before running this to create table
   //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
   try {
	   
	   	   conn=sqlconnector.connect();

           pst = conn.prepareStatement("INSERT INTO car_rental_testing.reservations ( car_id, user_name, start_date, start_time, end_date, end_time, has_gps, has_on_star, has_sirius_xm, is_arlington_club_member, base_cost, tax, discount, total_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,'230', '20', '20', '1000')");
//           pst.setString(1, role);
           

			pst.setString(1, car_id);
			pst.setString(2, user_name);
			pst.setString(3, start_date);
			pst.setString(4, start_time);
			pst.setString(5, end_date);
			pst.setString(6, end_time);
			pst.setBoolean(7, Boolean.parseBoolean(has_gps));
			pst.setBoolean(8, Boolean.parseBoolean(has_on_star));
			pst.setBoolean(9, Boolean.parseBoolean(has_sirius_xm));
			pst.setBoolean(10, Boolean.parseBoolean(is_arlington_club_member));
			pst.executeUpdate();
			
			
	          qry = conn.prepareStatement("select role_id from user_roles where user_name = ?");
	          qry.setString(1, username);
	          qrs = qry.executeQuery();
	          while(qrs.next()){
	        	   temp = qrs.getString(1);
	      
	          qry = conn.prepareStatement("select role_name from roles where role_id = ?");
	          qry.setString(1, temp);
	          qrs = qry.executeQuery();
	          while(qrs.next()){
	        	   temp = qrs.getString(1);
			
			if(temp.equals("Admin"))
        	{
	            RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");  
	            rd.forward(request,response);  
	        	}
	        	else if(temp.equals("Rental Manager"))
	        	{
	            RequestDispatcher rd=request.getRequestDispatcher("rentalmanagerhome.jsp");  
	            rd.forward(request,response);  
	        	}
	        	else if(temp.equals("User"))
	        	{
	            RequestDispatcher rd=request.getRequestDispatcher("userhome.jsp");  
	            rd.forward(request,response);  
	        	}	
		        out.print("<p style=\"color:red\">Record Successfully added</p>");
		        pst.close();
		        qry.close();
				conn.close();
			 }
	          }
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
   

 
