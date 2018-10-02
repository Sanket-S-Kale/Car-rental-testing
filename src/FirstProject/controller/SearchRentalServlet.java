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
import FirstProject.model.ViewReportDAO;

/**
 * Servlet implementation class RevokeRenterServlet
 */
@WebServlet("/SearchRentalServlet")
public class SearchRentalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRentalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Connection conn = null;
	      PreparedStatement pst = null;
	      ResultSet rs = null;
	      String username = request.getParameter("username");
	      int rentalid = Integer.parseInt(request.getParameter("rentalid"));
			try{
		      	
		      	conn=sqlconnector.connect();
		      	
		      pst = conn
		              .prepareStatement("SELECT * FROM car_rental_testing.reservations where user_name='"+username+"' or reservation_id = " + rentalid);
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
		doGet(request, response);
	}

}
