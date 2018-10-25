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
import FirstProject.model.carBooked;
//import Car_Rental_Util.sqlconnector;

public class CarCalenderServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String fromDate = request.getParameter("fromcalender");
  
  String toDate = request.getParameter("tocalender");

  if (fromDate.isEmpty()|| toDate.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("carCalender.jsp");
   out.println("<font color=red>Please fill all the fields</font>");
   rd.include(request, response);
  } else {
	  Connection conn = null;
      PreparedStatement pst = null;
      ResultSet rs = null;

  try {
	   	   conn=sqlconnector.connect();
           pst = conn.prepareStatement("SELECT r.reservation_id, r.user_name,r.start_date,r.start_time,r.end_date,r.end_time,c.car_name FROM car_rental_testing.reservations as r,car_rental_testing.cars as c where start_date between '"+fromDate+"' and '"+toDate+"' and r.car_id=c.car_id;");
			//pst.executeUpdate();
			rs = pst.executeQuery();
			
			ArrayList<carBooked> mylist=new ArrayList<carBooked>(); 
		      while(rs.next())
		      { 
		    	  carBooked obj= new carBooked();
		    	  obj.setreservation_id(rs.getInt(1));	
		    	  obj.setuser_name(rs.getString(2));
		    	  obj.setstart_date(rs.getString(3));
		    	  obj.setstart_time(rs.getString(4));
		    	  obj.setend_date(rs.getString(5));
		    	  obj.setend_time(rs.getString(6));
		    	  obj.setcar_name(rs.getString(7));
		    	  mylist.add(obj);   	
		    	  System.out.println(rs.getString(1));
		      }
		      pst.close();
			  conn.close();
		      request.setAttribute("queryResults1", mylist);
		      RequestDispatcher rd=request.getRequestDispatcher("carCalender.jsp");  
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
   

 
