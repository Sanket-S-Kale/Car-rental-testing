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

public class CheckReserveRentalServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String username=(String) request.getSession().getAttribute("name");
  
	  Connection conn = null;
      PreparedStatement pst = null;
      ResultSet rs = null;

   // inserting data into mysql database 
   // create a test database and student table before running this to create table
   //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
      if(username.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			   rd.include(request,response); 
		}else{
		
			try {
					
			   	   	conn=sqlconnector.connect();
	
			   	   	pst = conn.prepareStatement("select is_revoked from users where user_name = ?");
			   	   	pst.setString(1, username);
			   	   	rs = pst.executeQuery();
			   	 String is_revok = null;
			   	   	while(rs.next()){
			   	   		is_revok = rs.getString(1);
			   	   	}
			   	   	if(is_revok.equals("1")){
				   	   	RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
				   	 request.setAttribute("revokeError","Your rental reservation rights have been revoked");
					   rd.forward(request, response);
//					   	out.println("<font color=red>Your rental reservation rights have been revoked.</font>");
			   	   	}else{
					   	 RequestDispatcher rd = request.getRequestDispatcher("RequestRental.jsp");
					   	 rd.include(request,response); 
			   	   	}
			}catch(Exception ex){
				RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
				out.println("<font color=red>Some error occurred.</font>");
			   	rd.include(request,response); 
			}
		}
 

 }
}
