package FirstProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import Car_Rental_Util.sqlconnector;
import FirstProject.model.AvailableCars;
import FirstProject.model.ViewReportDAO;

public class SearchAvailableCarsServlet extends HttpServlet {
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
      	String  cpcty=request.getParameter("Capacity"); 
        String pickupdate=request.getParameter("pickupdate");  
        String dropoffdate=request.getParameter("dropoffdate"); 
        String pickuptime=request.getParameter("pickuptime");
        String dropofftime=request.getParameter("dropofftime");
        String gps1=request.getParameter("gps");
        System.out.println(gps1);
        Boolean gps= Boolean.parseBoolean(gps1);
        String onstar1=request.getParameter("onstar");
        Boolean onstar= Boolean.parseBoolean(onstar1);
        String siriusxm1=request.getParameter("siriusxm");
        Boolean siriusxm= Boolean.parseBoolean(siriusxm1);
        String clubmember1=request.getParameter("clubmember");
        Boolean clubmember= Boolean.parseBoolean(clubmember1);
      	int capacity=Integer.parseInt(cpcty);
      	
      pst = conn
              .prepareStatement("SELECT * FROM car_rental_testing.cars where capacity>="+capacity);
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
       	  obj.setAmount(payment_amount(rs.getDouble(4),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9),pickupdate,dropoffdate,gps1,onstar1,siriusxm1,clubmember1));
    	  mylist.add(obj);   	
    	  System.out.println(rs.getString(1));
      }
      request.setAttribute("queryResults", mylist);
      RequestDispatcher rd=request.getRequestDispatcher("ViewAvailableCars.jsp");  
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
 double payment_amount(double  Weekday_rate,double  Weekly_rate,double  gps_rate,double onstar_rate,double  sirusxm_rate,String pickupdate,String dropoffdate, String gps,String onstar, String sirusxm, String clubmember ) throws ParseException
 {
 	 double amount = 0;
 	 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
 	 java.util.Date pickup_date = sdf1.parse(pickupdate);
 	 java.util.Date dropoff_date = sdf1.parse(dropoffdate);
 	 long diff = dropoff_date.getTime()-pickup_date.getTime();
 	 int days=(int)(diff / (1000 * 60 * 60 * 24));
 	 System.out.println(gps);
 	 if(days/7==0)
 	 {
 		 amount=(days%7)*Weekday_rate;
 	 }
 	 if(days/7!=0)
 	 {
 		int weeks=days/7;
 		 amount=(weeks*Weekly_rate) + (days - (weeks*7))*Weekday_rate;
 	 }
 	 
 	 
 	 
 	 if(gps!=null && gps.equals("1"))
 	 {
 		 amount=amount+days*gps_rate;
 	 }
 	 if(onstar!=null && onstar.equals("2"))
 	 {
 		 amount=amount+days*onstar_rate; 
 	 }
 	 if(sirusxm!=null&&sirusxm.equals("3"))
 	 {
 		 amount=amount+days*sirusxm_rate;
 	 }
 	 if(clubmember!=null&&clubmember.equals("4"))
 	 {
 		 amount=amount- (0.01*amount);
 	 }
 	 
 	 amount= amount+ (0.0825*amount);

 	amount =Double.parseDouble(new DecimalFormat("##.##").format(amount));
 	 return amount;
 	   
 }
}
