package FirstProject.model;

import static org.junit.Assert.*;

import java.text.ParseException;

import Car_Rental_Util.sqlconnector;

import javax.swing.tree.VariableHeightLayoutCache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Car_Rental_Util.sqlconnector;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
public class AvailableCarsTest {
	
	AvailableCars price;
	static String temp;
	//declare variable here
	
	@Before
	public void setUp() throws Exception {
		//instantiate variable here
		price=new AvailableCars();
	}

	@FileParameters("src/csv/Payment_testing.csv")
	@Test
	// parameters for test() need to be the same as in the Excel test case
	public void test(double  Weekday_rate,double  Weekly_rate,double  gps_rate,double onstar_rate,double  sirusxm_rate,String pickupdate,String dropoffdate, String gps,String onstar, String sirusxm, String clubmember,double actualprice) throws ParseException {
		//	body goes here
		
		double result = price.payment_amount(Weekday_rate, Weekly_rate, gps_rate, onstar_rate, sirusxm_rate, pickupdate, dropoffdate, gps, onstar, sirusxm, clubmember);
		assertEquals(actualprice,result,0.01);
			
		}
}


