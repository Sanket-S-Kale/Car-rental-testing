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
public class AddCarTest {
	addCarError cartest;
	
	@Before
	public void setUp() throws Exception {
		//instantiate variable here
		cartest = new addCarError();
	}
	
	@Test
	@FileParameters("src/csv/cars.csv")
	public void test(String carname, String capacity,String weekdayrate, String weekendrate, String weeklyrate, String gpsrate,String onstarrate,String siriusxmrate,Boolean error) throws ServletException, IOException {
		
		addCarError result=cartest.setErrorMsg(carname, capacity, weekdayrate, weekendrate, weeklyrate, gpsrate, onstarrate, siriusxmrate);
		assertEquals(error,result.hasErrors);
		
	}

}