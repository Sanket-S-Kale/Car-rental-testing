package FirstProject.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car_Rental_Util.sqlconnector;
import FirstProject.model.RegisterErrors;

public class UserDetails {
	
	String user_name;
	String usr_password;
	String uta_id;
	String first_name;
	String last_name;
	String date_of_birth;
	String phone_number;
	String email;
	String address;
	String driving_license_number;
	Boolean is_revoked;

	
	 
public RegisterErrors setErrorMsg (String userName, String password, String utaid, String firstname, String lastname, String dob, String phonenumber, String email, String dl, String address) throws ServletException, IOException {
  
  /////////////////                           validate given input            /////////////////////////
  
  Pattern pattern = Pattern.compile("[A-Za-z0-9_-]+");
  Pattern hasUppercase = Pattern.compile("[A-Z]");
  Pattern hasLowercase = Pattern.compile("[a-z]");
  Pattern hasNumber = Pattern.compile("\\d");
  Pattern hasSpecialChar = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
  Pattern dofb = Pattern.compile("^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/(1[0-9][0-9][0-9]|2[0-9][0-9][0-9])$");
  Pattern mail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
   RegisterErrors re = new RegisterErrors();
  re.hasErrors = false;
  ///////////////////                         Validation for isRequired      ////////////////////////
  if (userName.isEmpty() || password.isEmpty() || utaid.isEmpty() || dob.isEmpty() || phonenumber.isEmpty()|| email.isEmpty()|| dl.isEmpty()|| address.isEmpty()) {
	  re.generalError = "All fields are mandatory";
	  re.hasErrors = true;
	  return re;
  }
   
   
///////                       Validation for userName:               ///////////////////
   
   
  else if (!pattern.matcher(userName).matches()){
		  re.usernameError = "Must be alphanumeric and can contain only _ and - ";
		  re.hasErrors = true;
		  return re;
	  }
	  else if (userName.length() <= 5){
		  re.usernameError = "Must be greatar than 5 char";
		  re.hasErrors = true;
		  return re;
	  }
	  else if (userName.length() >=16){
		  re.usernameError = "Must be less than 16 char";
		  re.hasErrors = true;
		  return re;
	  }
	  ///////              Validation for Password:         ////////////////////
	  
	  else if (password.length() < 6){
		  re.passwordError = "Must be greater than 6 char";
		  re.hasErrors = true;
		  return re;
		  
	  }
	  else if (!hasUppercase.matcher(password).find()) {
		  re.passwordError = "Must have at least One Upper Case";
		  re.hasErrors = true;
		  return re;
	  }
	  else if (!hasLowercase.matcher(password).find()) {
		  re.passwordError = "Must have at least One Lower Case";
		  re.hasErrors = true;
		  return re;
	  }
	  else if (!hasNumber.matcher(password).find()) {
		  re.passwordError = "Must have at least One Number";
		  re.hasErrors = true;
		  return re;
	  }
	  else if (!hasSpecialChar.matcher(password).find()) {
		  re.passwordError = "Must have at least One Special Character";
		  re.hasErrors = true;
		  return re;
	  }
	  //////////////////            Validation for UTA ID:           ///////////////////
	  
	  else if (utaid.length() != 10){
		  re.uidError = "Must be a 10 Digit Number Only";
		  re.hasErrors = true;
		  return re;
		  
	  }
	  else if (!utaid.matches("[0-9]+")){
		  re.uidError = "Must be a 10 Digit Number Only";
		  re.hasErrors = true;
		  return re;
		  
	  }
	  
	  /////////////                      Validation for Name:               ///////////////////
	  
	  else if (!firstname.matches("[A-Za-z]+")){
		  re.fnameError = "Must contain Alphabets Only";
		  re.hasErrors = true;
		  return re;
		  
	  }
	  
	  else if (!lastname.matches("[A-Za-z]+")){
		  re.lnameError = "Must contain Alphabets Only";
		  re.hasErrors = true;
		  return re;
		  
	  }
	  
	  //////////////                    Validation for DOB:                /////////////////////
	  
	  else if (!dofb.matcher(dob).matches()){
		  re.dobError = "Must be Valid Date Format";
		  re.hasErrors = true;
		  return re;
	  }
	  ////////////////////////////////////////////////////////(Incomplete)///////////////////
	  
	  ///////////                       Validation of Phone Number:       ///////////////////////
	  else if (phonenumber.length() != 10){
		  re.phoneError = "Must be 10 Digits in Length";
		  re.hasErrors = true;
		  return re;
		  
	  }
	  else if (!phonenumber.matches("[0-9]+")){
		  re.phoneError = "Must conatin Numbers Only";
		  re.hasErrors = true;
		  return re;
	  }
	  
	  ///////////////                  Validation for E-mail:         //////////////////////////
	  
	  else if (!mail.matcher(email).matches()){
		  re.emailError = "Must be valid e-mail format";
		  re.hasErrors = true;
		  return re;
	  }
	  
	  //////////////                   Validation for Drivers License      /////////////////////
	  
	  else if (dl.length() != 8){
		  re.dlError = "Must be 8 digits in length";
		  re.hasErrors = true;
		  return re;
		  
	  }
	  else if (!dl.matches("[0-9]+")){
		  re.dlError = "Must be Numeric Only";
		  re.hasErrors = true;
		  return re;
	  }
	  
	  //////////////                 Validation for Address                /////////////////////
	  
	  else if (address.length() < 10){
		  re.addressError = "Must Contain Minimum 10 Characters";
		  re.hasErrors = true;
		  return re;
		  
	  }
	  else if (address.length() >=100){
		  re.addressError = "Must Contain Less Than 100 Characters";
		  re.hasErrors = true;
		  return re;
	  }
	  

	  
  else {
	  
	  re.hasErrors = false;
	  return re;
  }
}

	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUsr_password() {
		return usr_password;
	}
	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}
	public String getUta_id() {
		return uta_id;
	}
	public void setUta_id(String uta_id) {
		this.uta_id = uta_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDriving_license_number() {
		return driving_license_number;
	}
	public void setDriving_license_number(String driving_license_number) {
		this.driving_license_number = driving_license_number;
	}
	public Boolean getIs_revoked() {
		return is_revoked;
	}
	public void setIs_revoked(Boolean is_revoked) {
		this.is_revoked = is_revoked;
	}

	
}
	

