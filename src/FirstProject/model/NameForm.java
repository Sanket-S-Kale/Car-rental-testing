package FirstProject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NameForm {
	static String temp;
    public static boolean validate(String name, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null, qry = null;
        ResultSet rs = null, qrs = null;
        

        String url = "jdbc:mysql://localhost:3307/";
        String dbName = "car_rental_testing";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "october123";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn
                    .prepareStatement("select * from users where user_name=? and usr_password=?");
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
    public static String parameter()
    {
    	return temp;
    }
    
    
}
