package FirstProject.model;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
public class UserDetailsTest {
	UserDetails usertest;
	
	@Before
	public void setUp() throws Exception {
		//instantiate variable here
		usertest = new UserDetails();
	}
	
	@Test
	@FileParameters("src/csv/UserDetails.csv")
	public void test(String userName, String password, String utaid,String role, String firstname, String lastname, String dob, String phonenumber, String email, String dl, String address, boolean hasErrors) throws ServletException, IOException {
		
		RegisterErrors result=usertest.setErrorMsg(userName, password, utaid, firstname, lastname, dob, phonenumber, email, dl, address);
		assertEquals(hasErrors,result.hasErrors);
		
	}

}