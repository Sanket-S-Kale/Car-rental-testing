package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import functions.Car_Rental_Test;
import java.util.Random;

public class CarRental_UpdateProfile_Error extends Car_Rental_Test {
  
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL, sSharedUIMapPath;
  Random dLicense = new Random();
  int drivingLicense;
  String drivingLicenseString;
  
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette","C:\\GeckoSelenium\\geckodriver.exe");
    driver = new FirefoxDriver();
    prop = new Properties();
    prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
    sAppURL = prop.getProperty("sAppURL");
    sSharedUIMapPath = prop.getProperty("SharedUIMap");
    prop.load(new FileInputStream(sSharedUIMapPath));
  }

  @Test
  public void testMyFirstWebDriver() throws Exception {
	driver.get(sAppURL);
	Login(driver, "sreekar", "Root-123");
	driver.findElement(By.xpath(prop.getProperty("Btn_ManagerUpdateProfile"))).click();
	driver.findElement(By.xpath(prop.getProperty("Txt_Username"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	String err=driver.findElement(By.xpath(prop.getProperty("Mandatory_Fields_Error_msg"))).getText();
	assertEquals("All fields are mandatory",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_Username"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_Username"))).sendKeys("sr");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("name_field_error_msg"))).getText();
	assertEquals("Must be greatar than 5 char",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_Password"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_Password"))).sendKeys("sr");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("password_field_error_msg"))).getText();
	assertEquals("Must be greater than 6 char",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_Password"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_Password"))).sendKeys("Root123");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("password_field_error_msg"))).getText();
	assertEquals("Must have at least One Special Character",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_UTAID"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_UTAID"))).sendKeys("1001234");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("utaid_field_error_msg"))).getText();
	assertEquals("Must be a 10 Digit Number Only",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_DOB"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_DOB"))).sendKeys("12/1234");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("dateofbirth_error_msg"))).getText();
	assertEquals("Must be Valid Date Format",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_Firstname"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_Firstname"))).sendKeys("sre*");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("firstname_error_msg"))).getText();
	assertEquals("Must contain Alphabets Only",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_LastName"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_LastName"))).sendKeys("sre*");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("lastname_error_msg"))).getText();
	assertEquals("Must contain Alphabets Only",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_PhoneNumber"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_PhoneNumber"))).sendKeys("23477");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("phonenumber_error_msg"))).getText();
	assertEquals("Must be 10 Digits in Length",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_Email"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_Email"))).sendKeys("sreekar");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("email_error_msg"))).getText();
	assertEquals("Must be valid e-mail format",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_DrivingLicense"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_DrivingLicense"))).sendKeys("1234");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("dl_error_msg"))).getText();
	assertEquals("Must be 8 digits in length",err);
	driver.findElement(By.xpath(prop.getProperty("Txt_Address"))).clear();
	driver.findElement(By.xpath(prop.getProperty("Txt_Address"))).sendKeys("1234");
	driver.findElement(By.xpath(prop.getProperty("Btn_Update_Profile"))).click();
	err=driver.findElement(By.xpath(prop.getProperty("address_error_msg"))).getText();
	assertEquals("Must Contain Minimum 10 Characters",err);
	
	
  }

  @After
  public void tearDown() throws Exception {
   driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
