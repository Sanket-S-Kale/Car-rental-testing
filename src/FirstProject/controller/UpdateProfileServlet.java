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

public class UpdateProfileServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String userName = request.getParameter("username");
  String password = request.getParameter("password");
  String utaid = request.getParameter("utaid");
  String firstname = request.getParameter("firstname");
  String lastname = request.getParameter("lastname");
  String dob = request.getParameter("dob");
  String phonenumber = request.getParameter("phonenumber");
  String email = request.getParameter("email");
  String dl = request.getParameter("dl");
  String address = request.getParameter("address");

  // validate given input
  if (userName.isEmpty() || password.isEmpty() || utaid.isEmpty() || dob.isEmpty() || phonenumber.isEmpty()|| email.isEmpty()|| dl.isEmpty()|| address.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("EditProfile.jsp");
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
	   	   String username=(String) request.getSession().getAttribute("name");
           
           pst = conn
                   .prepareStatement("UPDATE car_rental_testing.users SET user_name=?, usr_password=?, uta_id=?, first_name=?, last_name=?, date_of_birth=?, phone_number=?, email=?, address=?, driving_license_number=? WHERE user_name='"+username+"'"
);
  

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

			conn.close();
			
			RequestDispatcher rd=request.getRequestDispatcher("EditProfile.jsp");
			out.print("<p style=\"color:red\">Record Successfully Updated</p>");
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
   

 
