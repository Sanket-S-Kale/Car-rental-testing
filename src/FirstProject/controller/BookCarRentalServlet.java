package FirstProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car_Rental_Util.sqlconnector;
import FirstProject.model.AvailableCars;
import FirstProject.model.ViewReportDAO;

public class BookCarRentalServlet extends HttpServlet {
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
      	//String username=(String) request.getSession().getAttribute("name");
      	int  carid=Integer.parseInt(request.getParameter("car_id"));
      	String pickupdate=request.getParameter("pickupdate");
      	String pickuptime=request.getParameter("pickuptime");
        String dropoffdate=request.getParameter("dropoffdate");
        String dropofftime=request.getParameter("dropofftime");
        String gps=request.getParameter("gps");
        String onstar=request.getParameter("onstar");
        String siriusxm=request.getParameter("siriusxm");
        String clubmember=request.getParameter("clubmember");
        
        
        String amount=request.getParameter("amount1");
      	
      pst = conn
              .prepareStatement("SELECT * FROM car_rental_testing.cars where car_id="+carid);
      //pst.setString(1, name);
      //pst.setString(2, pass);
      

      rs = pst.executeQuery();
      
      ArrayList<AvailableCars> mylist=new ArrayList<AvailableCars>(); 
      while(rs.next())
      { 
    	  AvailableCars obj= new AvailableCars();
    	  obj.setCar_id(rs.getInt(1));
    	  obj.setCar_name(rs.getString(2));
    	  obj.setCapacity(rs.getInt(3));
    	  obj.setWeekday_rate(rs.getDouble(4));
    	  obj.setWeekend_rate(rs.getDouble(5));
    	  obj.setWeekly_rate(rs.getDouble(6));
    	  obj.setGps_rate(rs.getDouble(7));
    	  obj.setOnstar_rate(rs.getDouble(8));
    	  obj.setSirusXM_rate(rs.getDouble(9));
    	  obj.setPickupdate(pickupdate);
    	  obj.setDropoffdate(dropoffdate);
    	  obj.setPickuptime(pickuptime);
    	  obj.setDropofftime(dropofftime);
    	  obj.setGps(gps);
    	  obj.setOnstar(onstar);
    	  obj.setSiriusxp(siriusxm);
    	  obj.setClubmember(clubmember);
    	  obj.setAmount(Double.parseDouble(amount));
    	  mylist.add(obj);   
    	  System.out.println(rs.getString(1));
      }
      
      
     
      request.setAttribute("queryResults", mylist);
      RequestDispatcher rd=request.getRequestDispatcher("BookCar.jsp");  
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
