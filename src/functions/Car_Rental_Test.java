package functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
 
public class Car_Rental_Test {   
	public static WebDriver driver;
	public static Properties prop; 
 public void Login (WebDriver driver, String sUserName, String sPassword) {
	driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);
	driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);
	driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click(); 
	}
 
 public void AddNewUser (WebDriver driver, String string, String string2, String string3,String string4,String string5,String string6,String string7,String string8,String string9,String string10,String string11){
		driver.findElement(By.xpath(prop.getProperty("Txt_username_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_username_1"))).sendKeys(string);
		driver.findElement(By.xpath(prop.getProperty("Txt_password_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_password_1"))).sendKeys(string2);
		driver.findElement(By.xpath(prop.getProperty("Txt_utaid_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_utaid_1"))).sendKeys(string3);
		driver.findElement(By.xpath(prop.getProperty("Txt_firstname_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_firstname_1"))).sendKeys(string4);
		driver.findElement(By.xpath(prop.getProperty("Txt_lastname_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_lastname_1"))).sendKeys(string5);
		driver.findElement(By.xpath(prop.getProperty("Txt_dateofbirth_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_dateofbirth_1"))).sendKeys(string6);
		driver.findElement(By.xpath(prop.getProperty("Txt_PhoneNumber"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_PhoneNumber"))).sendKeys(string7);
		driver.findElement(By.xpath(prop.getProperty("Txt_email_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_email_1"))).sendKeys(string8);
		driver.findElement(By.xpath(prop.getProperty("Txt_drivinglicense_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_drivinglicense_1"))).sendKeys(string9);
		driver.findElement(By.xpath(prop.getProperty("Txt_address_1"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_address_1"))).sendKeys(string10);
		new Select(driver.findElement(By.id(prop.getProperty("drpdown_role_1")))).selectByVisibleText(string11);
	    driver.findElement(By.xpath(prop.getProperty("btn_register"))).click();
	    
	} 
	
	public void UpdateProfile (WebDriver driver, String string, String string2, String string3,String string4,String string5,String string6,String string7,String string8,String string9,String string10){
		driver.findElement(By.xpath(prop.getProperty("Txt_Username"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Username"))).sendKeys(string);
		driver.findElement(By.xpath(prop.getProperty("Txt_Password"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Password"))).sendKeys(string2);
		driver.findElement(By.xpath(prop.getProperty("Txt_UTAID"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_UTAID"))).sendKeys(string3);
		driver.findElement(By.xpath(prop.getProperty("Txt_Firstname"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Firstname"))).sendKeys(string4);
		driver.findElement(By.xpath(prop.getProperty("Txt_LastName"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_LastName"))).sendKeys(string5);
		driver.findElement(By.xpath(prop.getProperty("Txt_DOB"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_DOB"))).sendKeys(string6);
		driver.findElement(By.xpath(prop.getProperty("Txt_PhoneNumber"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_PhoneNumber"))).sendKeys(string7);
		driver.findElement(By.xpath(prop.getProperty("Txt_Email"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Email"))).sendKeys(string8);
		driver.findElement(By.xpath(prop.getProperty("Txt_DrivingLicense"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_DrivingLicense"))).sendKeys(string9);
		driver.findElement(By.xpath(prop.getProperty("Txt_Address"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Address"))).sendKeys(string10);
	    driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	    
	} 
	
	public void SearchAvailableCars (WebDriver driver, String string, String string2, String string3,String string4,String string5){
		driver.findElement(By.xpath(prop.getProperty("Txt_PickupDate"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_PickupDate"))).sendKeys(string);
		driver.findElement(By.xpath(prop.getProperty("Txt_PickupTime"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_PickupTime"))).sendKeys(string2);
		driver.findElement(By.xpath(prop.getProperty("Txt_EndDate"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_EndDate"))).sendKeys(string3);
		driver.findElement(By.xpath(prop.getProperty("Txt_EndTime"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_EndTime"))).sendKeys(string4);
		driver.findElement(By.xpath(prop.getProperty("Txt_Capacity"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Capacity"))).sendKeys(string5);
		driver.findElement(By.xpath(prop.getProperty("Chkbox_GPS"))).click();
		driver.findElement(By.xpath(prop.getProperty("Chkbox_Onstar"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Btn_SearchCar"))).click();
	    
	} 
	
	public void EnterCardDetails (WebDriver driver, String string, String string2, String string3){
		driver.findElement(By.xpath(prop.getProperty("Txt_CardNumber"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_CardNumber"))).sendKeys(string);
		driver.findElement(By.xpath(prop.getProperty("Txt_CVV"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_CVV"))).sendKeys(string2);
		driver.findElement(By.xpath(prop.getProperty("Txt_Expiry_Date"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Expiry_Date"))).sendKeys(string3);
	    driver.findElement(By.xpath(prop.getProperty("Btn_BookMyCar_Submit"))).click();
	    
	} 
	
	public void SearchCar (WebDriver driver, String string, String string2){
		driver.findElement(By.xpath(prop.getProperty("TxtUsername"))).clear();
		driver.findElement(By.xpath(prop.getProperty("TxtUsername"))).sendKeys(string);
		driver.findElement(By.xpath(prop.getProperty("Btn_Search"))).click();
		driver.findElement(By.xpath(prop.getProperty("Btn_ManagerSearchRental"))).click();
		driver.findElement(By.xpath(prop.getProperty("TxtRentalId"))).clear();
		driver.findElement(By.xpath(prop.getProperty("TxtRentalId"))).sendKeys(string2);
		driver.findElement(By.xpath(prop.getProperty("Btn_Search"))).click();
	    
	} 
	
	public void AddCar (WebDriver driver, String string, String string2, String string3,String string4,String string5,String string6,String string7,String string8){
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_CarName"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_CarName"))).sendKeys(string);
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_Capacity"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_Capacity"))).sendKeys(string2);
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_WeekdayRate"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_WeekdayRate"))).sendKeys(string3);
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_weekendRate"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_weekendRate"))).sendKeys(string4);
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_WeeklyRate"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_WeeklyRate"))).sendKeys(string5);
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_GPSRate"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_GPSRate"))).sendKeys(string6);
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_OnstarRate"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Txt_addCar_OnstarRate"))).sendKeys(string7);
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_SirusxmRate"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_addCar_SirusxmRate"))).sendKeys(string8);
	    driver.findElement(By.xpath(prop.getProperty("Btn_addCar"))).click();
	    
	} 

} 