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
public class carBookedTest {
	carBooked carbooktest;
	
	@Before
	public void setUp() throws Exception {
		//instantiate variable here
		carbooktest = new carBooked();
	}
	
	@Test
	@FileParameters("src/csv/carBooked.csv")
	public void test(String cardnumber, String cvv,String kmonth,String kyear,boolean hasErrors) throws ServletException, IOException {
		
		boolean result=carbooktest.setErrorMsg(cardnumber, cvv, kmonth, kyear);
		assertEquals(hasErrors,result);
		
	}

}