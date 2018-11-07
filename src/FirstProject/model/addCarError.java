package FirstProject.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car_Rental_Util.sqlconnector;
import FirstProject.model.RegisterErrors;
import FirstProject.model.addCarError;
import Car_Rental_Util.sqlconnector;
import java.util.Random;
import java.util.regex.Pattern;


public class addCarError {
	public String capacityError;
	public String weekdayError;
	public String weekendError;
	public String weeklyError;
	public String gpsError;
	public String onstarError;
	public String siriusxmError;
	public String carnameError;
	
	
	public Boolean setErrorMsg(String carname, String capacity,String weekdayrate, String weekendrate, String weeklyrate, String gpsrate,String onstarrate,String siriusxmrate) throws ServletException, IOException{
		  
		  addCarError ae = new addCarError();
		  boolean hasErrors = false;
		  
		  Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
		  Pattern hasUppercase = Pattern.compile("[A-Z]");
		  Pattern hasLowercase = Pattern.compile("[a-z]");
		  Pattern hasNumber = Pattern.compile("\\d");
		  Pattern hasSpecialChar = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
		  Pattern dofb = Pattern.compile("^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/(1[0-9][0-9][0-9]|2[0-9][0-9][0-9])$");
		  Pattern mail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})$");
		  Pattern dollar = Pattern.compile("^[0-9]+\\.[0-9][0-9]");
		//  int capacityv = Integer.parseInt(capacity);
		
		if (carname.isEmpty() || capacity.isEmpty() || weekdayrate.isEmpty() || weekendrate.isEmpty() || gpsrate.isEmpty() || onstarrate.isEmpty()|| siriusxmrate.isEmpty()) {
//			   RequestDispatcher rd = request.getRequestDispatcher("addcar.jsp");
//			   out.println("<font color=red>Please fill all the fields</font>");
//			   rd.include(request, response);
			 hasErrors = true;
			 return hasErrors;
			  } 
			  
			  //////////////////               Validation for Car Name:                /////////////////////
			  
			  else if (hasSpecialChar.matcher(carname).find()) {
				  ae.carnameError = "Must be alphanumeric Only. ";
				  hasErrors = true;
				  return hasErrors;
			  }
			  // Since car_id is PK in database, Car Name need not be unique //
			  
			  /////////////////               Validation for Capacity                  /////////////////////
			  
			  else if (!capacity.matches("[0-9]+")){
				  ae.capacityError = "Must Contain Number Only";
				  hasErrors = true;
				  return hasErrors;
				 
			  }
			 
				 
			  
			  
			  	else if (Integer.parseInt(capacity) > 25){
			  	ae.capacityError = "Maximum Capacity is 25";
			  	hasErrors = true;
			  	 return hasErrors;
				 
			 }
			  
			  /////////////////              Validation for Weekday Rate:          //////////////////////////
			  
			  else if (!dollar.matcher(weekdayrate).find()) {
				  ae.weekdayError = "Use Valid Currency Format";
				  hasErrors = true;
				  return hasErrors;
				 
			  }
			  
			  /////////////////              Validation for Weekend Rate:          ///////////////////////////
			  
			  else if (!dollar.matcher(weekendrate).find()) {
				  ae.weekendError = "Use Valid Currency Format";
				  hasErrors = true;
				  return hasErrors;
			  }
			  
			 //////////////////             Validation for Weekly Rate:             /////////////////////////
			  
			  else if (!dollar.matcher(weeklyrate).find()) {
				  ae.weeklyError = "Use Valid Currency Format";
				  hasErrors = true;
				  return hasErrors;
			  }
			  
			  /////////////////             Validation for GPS Rate:               ///////////////////////////
			  
			  else if (!dollar.matcher(gpsrate).find()) {
				  ae.gpsError = "Use Valid Currency Format";
				  hasErrors = true;
				  return hasErrors;
			  }
			  
			  ////////////////              Validation for OnStar Rate:             ////////////////////////
			  
			  else if (!dollar.matcher(onstarrate).find()) {
				  ae.onstarError = "Use Valid Currency Format";
				  hasErrors = true;
				  return hasErrors;
			  }
			  
			  ////////////////             Validation for SiriusXM Rate:              ///////////////////////
			  
			  else if (!dollar.matcher(siriusxmrate).find()) {
				  ae.siriusxmError = "Use Valid Currency Format";
				  hasErrors = true;
				  return hasErrors;
			  }
			  
//			  if(hasErrors == true){
//				  RequestDispatcher rd20 = request.getRequestDispatcher("addcar.jsp");
//				  request.setAttribute("errorList",ae);
//				   rd20.forward(request, response);
//			  }
//			  
			  else {
				  hasErrors = false;
				  return hasErrors;
		  }
	
		
	}
	
	public String getCarnameError() {
		return carnameError;
	}
	public void setCarnameError(String carnameError) {
		this.carnameError = carnameError;
	}
	public String getCapacityError() {
		return capacityError;
	}
	public void setCapacityError(String capacityError) {
		this.capacityError = capacityError;
	}
	public String getWeekdayError() {
		return weekdayError;
	}
	public void setWeekdayError(String weekdayError) {
		this.weekdayError = weekdayError;
	}
	public String getWeekendError() {
		return weekendError;
	}
	public void setWeekendError(String weekendError) {
		this.weekendError = weekendError;
	}
	public String getWeeklyError() {
		return weeklyError;
	}
	public void setWeeklyError(String weeklyError) {
		this.weeklyError = weeklyError;
	}
	public String getGpsError() {
		return gpsError;
	}
	public void setGpsError(String gpsError) {
		this.gpsError = gpsError;
	}
	public String getOnstarError() {
		return onstarError;
	}
	public void setOnstarError(String onstarError) {
		this.onstarError = onstarError;
	}
	public String getSiriusxmError() {
		return siriusxmError;
	}
	public void setSiriusxmError(String siriusxmError) {
		this.siriusxmError = siriusxmError;
	}
	
	
}