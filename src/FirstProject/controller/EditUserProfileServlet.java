package FirstProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car_Rental_Util.sqlconnector;
import FirstProject.model.UserDetails;

@WebServlet("/EditUserProfileServlet")
public class EditUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditUserProfileServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String username1 = request.getParameter("username");
		System.out.println(username1);
		Connection conn = null;
	      PreparedStatement pst = null;
	      ResultSet rs = null;
		
		if(username1.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("EditUserProfile.jsp");
			   out.println("<font color=red>Please fill all the fields</font>");
			   rd.include(request,response); 
		}else{
		
			try{
		      	
		      	conn=sqlconnector.connect();
		      	
		      pst = conn
		              .prepareStatement("SELECT * FROM car_rental_testing.users where user_name='"+username1+"'");
		      rs = pst.executeQuery();
		     
		      ArrayList<UserDetails> mylist=new ArrayList<UserDetails>(); 
		      while(rs.next())
		      { 
		    	  UserDetails obj= new UserDetails();
		    	  obj.setUser_name(rs.getString(1));
		    	  obj.setUsr_password(rs.getString(2));
		    	  obj.setUta_id(rs.getString(3));
		    	  obj.setFirst_name(rs.getString(4));
		    	  obj.setLast_name(rs.getString(5));
		    	  obj.setDate_of_birth(rs.getString(6));
		    	  obj.setPhone_number(rs.getString(7));
		    	  obj.setEmail(rs.getString(8));
		    	  obj.setAddress(rs.getString(9));
		    	  obj.setDriving_license_number(rs.getString(10));
		    	  mylist.add(obj);   	

		      }
		      request.setAttribute("queryResults", mylist);
		      RequestDispatcher rd=request.getRequestDispatcher("EditProfile.jsp");  
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
		doGet(request, response);
	}

}
