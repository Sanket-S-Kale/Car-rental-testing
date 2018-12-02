package FirstProject.model;

import java.util.regex.Pattern;

public class carBooked {
	
	String cardnumber;
	String cvv;
	String expmonth;
	String stardate;
	String enddate;
	String testyear;
	String testmonth;

	
	public boolean setErrorMsg (String cardnumber, String cvv, String kmonth, String kyear){
		
		boolean hasErrors = false;

		   RegisterErrors re = new RegisterErrors();
		   
		   if (cardnumber.isEmpty() || cvv.isEmpty() || kmonth.isEmpty()||kyear.isEmpty()){
			   re.fnameError = "Cant be Empty";
			   hasErrors = true;
				  return hasErrors;
			    }
		   else if (!cardnumber.matches("[0-9]+")){
			   re.fnameError = "Has to be a number";
				  hasErrors = true;
				  return hasErrors;
				}
		   else if (cardnumber.length() != 16){
			   re.fnameError = "Card number has to be 16 Digits";
			   hasErrors = true;
			   return hasErrors;
		   }
		   else if (!cvv.matches("[0-9]+")){
			   re.fnameError = "CVV must conatin only numbers";
			   	  hasErrors = true;
			   	  return hasErrors;
		   }
		   else if (cvv.length() != 3){
			   re.fnameError = "CVV has to be 3 digits only";
			   	  hasErrors = true;
			   	  return hasErrors;
		   }
		   
		   else if (!kyear.matches("[0-9]+")){
			   re.fnameError = "Year has to follow correct format";
			   hasErrors = true;
		   	return hasErrors;
		   	
		   }
		   else if (kyear.length() != 4){
			   re.fnameError = "Year has to be 4 digits";
			   hasErrors = true;
			   return hasErrors;
		   }
		   
		   else if (Integer.parseInt(kyear) <= 2018){
			   re.fnameError = "Use Valid Card";
			   hasErrors = true;
			   return hasErrors;
		   }
		
		   
		   else if (Integer.parseInt(kmonth) > 12){
			   re.fnameError = "Use Valid Month Format";
			   hasErrors = true;
			   return hasErrors;
		   }
		   else if (Integer.parseInt(kmonth) < 1){
			   re.fnameError = "Use Valid Month Format";
			   hasErrors = true;
			   return hasErrors;
		   }
	
		   else{
			   hasErrors = false;
			   return hasErrors;
		   }
		
		
	}
	
	int reservation_id;
//	int car_id;
	String user_name;
	String car_name;
	String start_date;
	String end_date;
	String start_time;
	String end_time;
	public String getstart_date() {
		return start_date;
	}
	public void setstart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getend_date() {
		return end_date;
	}
	public void setend_date(String end_date) {
		this.end_date = end_date;
	}
	public String getstart_time() {
		return start_time;
	}
	public void setstart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getend_time() {
		return end_time;
	}
	public void setend_time(String end_time) {
		this.end_time = end_time;
	}
	public String getcar_name() {
		return car_name;
	}
	public void setcar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getuser_name() {
		return user_name;
	}
	public void setuser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getreservation_id() {
		return reservation_id;
	}
	public void setreservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	
}
