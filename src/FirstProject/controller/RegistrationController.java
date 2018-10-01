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


public class RegistrationController extends HttpServlet {
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

  // validate given input
  if (userName.isEmpty() || password.isEmpty() || utaid.isEmpty() || role.isEmpty() || dob.isEmpty() || phonenumber.isEmpty()|| email.isEmpty()|| dl.isEmpty()|| address.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
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
	   
       String url = "jdbc:mysql://localhost:3306/";
       String dbName = "car_rental_testing";
       String driver = "com.mysql.jdbc.Driver";
       String userName_1 = "root";
       String password_1 = "october123";
      
           Class.forName(driver).newInstance();
           conn = DriverManager
                   .getConnection(url + dbName, userName_1, password_1);

           pst = conn.prepareStatement("select role_id from roles where role_name = ?");
           pst.setString(1, role);
           
           ResultSet roleResult = pst.executeQuery();
           int roleId = 0;
           while (roleResult.next())
        	   roleId = roleResult.getInt(1);
           System.out.println(roleId);
           pst.close();
           
           pst = conn
                   .prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?,?)");
  

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
   

 
