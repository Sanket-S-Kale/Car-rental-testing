package com.gomavs.rental.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Data;

/**
 * @author Sanket
 *
 */
@Entity
@Data
public class Users {

	@Id
	@Column
	@NotBlank
	@Size(min=5, max=16)
	private String username;
	
	@Column
	@NotBlank
	@Size(min=8, max=50)
	private String password;
	
	@Column
	@Pattern(regexp = "[0-9]*$", message="Must contain numbers")
	@Size(min=10, max=10, message = "Must be a 10 digit number")
	private String utaid;
	
	@Column
	@NotBlank
	private String firstname;
	
	@Column
	@NotBlank
	private String lastname;
	
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date dob;
	
	@Column
	@NotNull
	@Pattern(regexp = "[0-9]*$", message="Must contain numbers")
	@Size(min=10, max=10, message = "Must be a 10 digit number")
	private String phonenumber;
	

	@Column
	@NotBlank
	@Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Must be a well-formed email address")
	private String email;
	
	@Column
	@NotBlank
	private String address;
	
	@Column
	@NumberFormat
	@NotBlank
	@Size(min=8, max=8)
	private String dlnumber;
	
	@Column
	private Boolean isrevoked;
	
	@Column
	@NotNull
	@NotBlank
	private String role;

}
