package FirstProject.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Car_Rental_Util.sqlconnector;
import FirstProject.model.LoginDAO;

public class LoginServlet extends HttpServlet{
	static String temp;
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        System.out.println("I am here");
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", n);

        if(validate(n, p)){  
        	if(parameter(temp).equals("Admin"))
        	{
            RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");  
            rd.forward(request,response);  
        	}
        	else if(parameter(temp).equals("Rental Manager"))
        	{
            RequestDispatcher rd=request.getRequestDispatcher("rentalmanagerhome.jsp");  
            rd.forward(request,response);  
        	}
        	else 
        	{
            RequestDispatcher rd=request.getRequestDispatcher("userhome.jsp");  
            rd.forward(request,response);  
        	}
        }  
        else{  
            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);  
        }  

        out.close();  
    }  


public boolean validate(String name, String pass) {        
    boolean status = false;
    Connection conn = null;
    PreparedStatement pst = null, qry = null;
    ResultSet rs = null, qrs = null;
    

        try{
        	
        	conn=sqlconnector.connect();
        pst = conn.prepareStatement("select * from car_rental_testing.users where user_name=? and usr_password=?");
        pst.setString(1, name);
        pst.setString(2, pass);
        

        rs = pst.executeQuery();
        
        while(rs.next())
        { 
          qry = conn.prepareStatement("select role_id from user_roles where user_name = ?");
          qry.setString(1, name);
          qrs = qry.executeQuery();
          while(qrs.next()){
        	   temp = qrs.getString(1);
          }
          
          qry = conn.prepareStatement("select role_name from roles where role_id = ?");
          qry.setString(1, temp);
          qrs = qry.executeQuery();
          while(qrs.next()){
        	   temp = qrs.getString(1);
          }
          
          System.out.println(temp);
          status = true;
        }
        

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
    return status;
    
   
}
public static String parameter(String temp)
{
	return temp;
}


}

