package FirstProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car_Rental_Util.sqlconnector;

/**
 * Servlet implementation class RevokeRenterServlet
 */
@WebServlet("/RevokeRenterServlet")
public class RevokeRenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevokeRenterServlet() {
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
		String username = request.getParameter("username");
		
		if(username.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("RevokeRenter.jsp");
			   out.println("<font color=red>Please fill all the fields</font>");
			   rd.include(request,response); 
		}else{
		
			try {
					Connection conn = null;
					PreparedStatement pst = null;
			   	   	conn=sqlconnector.connect();
	
			   	   	pst = conn.prepareStatement("update users set is_revoked='1' where user_name = ?");
			   	   	pst.setString(1, username);
			   	   	pst.executeUpdate();
			   	   	out.println("<font color=green>User Successfuly revoked</font>");
			   	 RequestDispatcher rd = request.getRequestDispatcher("RevokeRenter.jsp");
			   	rd.include(request,response); 
			}catch(Exception ex){
				RequestDispatcher rd = request.getRequestDispatcher("RevokeRenter.jsp");
				out.println("<font color=red>Some error occurred.</font>");
			   	rd.include(request,response); 
			}
		}
		doGet(request, response);
	}

}
