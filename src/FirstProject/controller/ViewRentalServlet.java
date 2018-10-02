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

public class ViewRentalServlet extends HttpServlet {
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
      	String username=(String) request.getSession().getAttribute("name");
      	
      pst = conn
              .prepareStatement("SELECT car_name,user_name,start_date,start_time,end_date,end_time,reservation_id FROM car_rental_testing.reservations rs, car_rental_testing.cars cr where rs.car_id=cr.car_id and rs.user_name='"+username+"'");
      //pst.setString(1, name);
      //pst.setString(2, pass);
      

      rs = pst.executeQuery();
      
      ArrayList<ViewReportDAO> mylist=new ArrayList<ViewReportDAO>(); 
      while(rs.next())
      { 
    	  ViewReportDAO obj= new ViewReportDAO();
    	  obj.setCar_name(rs.getString(1));
    	  obj.setUser_name(rs.getString(2));
    	  obj.setStart_date(rs.getString(3));
    	  obj.setStart_time(rs.getString(4));
    	  obj.setClose_date(rs.getString(5));
    	  obj.setClose_time(rs.getString(6));
    	  obj.setReservation_id(rs.getInt(7));
    	  mylist.add(obj);   	
    	  System.out.println(rs.getString(1));
      }
      request.setAttribute("queryResults", mylist);
      RequestDispatcher rd=request.getRequestDispatcher("ViewUserBookings.jsp");  
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
