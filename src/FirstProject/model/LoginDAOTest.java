package FirstProject.model;

import static org.junit.Assert.*;
import Car_Rental_Util.sqlconnector;

import javax.swing.tree.VariableHeightLayoutCache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Car_Rental_Util.sqlconnector;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import FirstProject.model.LoginDAO;

@RunWith(JUnitParamsRunner.class)
public class LoginDAOTest {
	
	LoginDAO login;
	static String temp;
	//declare variable here
	
	@Before
	public void setUp() throws Exception {
		//instantiate variable here
		login=new LoginDAO();
	}

	@FileParameters("src/csv/LoginDAO.csv")
	@Test
	// parameters for test() need to be the same as in the Excel test case
	public void test(String username,String password,String role,Boolean check) {
		//	body goes here
		
		Boolean result = LoginDAO.validate(username, password);
		assertEquals(check,result);
		String s1=LoginDAO.parameter();
		assertEquals(role,s1);
		
		
		}
}


