package FirstProject.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import FirstProject.model.LoginDAO;

public class LoginServlet extends HttpServlet{

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

        if(LoginDAO.validate(n, p)){  
        	if(LoginDAO.parameter().equals("Admin"))
        	{
            RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");  
            rd.forward(request,response);  
        	}
        	else if(LoginDAO.parameter().equals("Rental Manager"))
        	{
            RequestDispatcher rd=request.getRequestDispatcher("rentalmanagerhome.jsp");  
            rd.forward(request,response);  
        	}
        	else if(LoginDAO.parameter().equals("User"))
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
} 
