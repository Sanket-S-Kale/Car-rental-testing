package Car_Rental_Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlconnector {
	
	public static Connection connect()
	
	{Connection conn = null;
	  PreparedStatement pst = null;
	  ResultSet rs = null;
		 
	  try {
		  String url = "jdbc:mysql://localhost:3307/";
	      String dbName = "car_rental_testing";
	      String timezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	      String driver = "com.mysql.jdbc.Driver";
	      String userName_1 = "root";
	      String password_1 = "october123";
	      Class.forName(driver).newInstance();
	      conn = DriverManager.getConnection(url + dbName + timezone, userName_1, password_1);
		 }
		 catch (Exception e) {
	           System.out.println(e);
	       } 
		return conn;
	}
}
