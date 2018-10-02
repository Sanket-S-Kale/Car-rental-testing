package FirstProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car_Rental_Util.sqlconnector;
import FirstProject.model.ViewReportDAO;

public class CancelBookingServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  
	  Connection conn = null;
      PreparedStatement pst = null;
      ResultSet rs = null;

   // inserting data into mysql database 
   // create a test database and student table before running this to create table
   //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
      try{
      	
      	conn=sqlconnector.connect();
      	int  reservation_id=Integer.parseInt(request.getParameter("reservation_id"));
      	System.out.println(reservation_id);
      	//String username=(String) request.getSession().getAttribute("name");
      	
      pst = conn
              .prepareStatement("DELETE FROM car_rental_testing.reservations WHERE reservation_id="+reservation_id);
      //pst.setString(1, name);
      //pst.setString(2, pass);
      

      pst.executeUpdate();
      
     
      RequestDispatcher rd=request.getRequestDispatcher("ViewRentalServlet");  
      rd.include(request,response);
      

  } catch (Exception e) {
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
