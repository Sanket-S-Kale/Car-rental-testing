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

public class CarRental_User_UpdateProfile extends Car_Rental_Test {
  
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
	  drivingLicense = 10000000+dLicense.nextInt(99999999);
	  String drivingLicenseString = Integer.toString(drivingLicense);
	driver.get(sAppURL);
	Login(driver, "sreekar", "Root-123");
	driver.findElement(By.xpath(prop.getProperty("Lnk_UpdateProfile"))).click();
	UpdateProfile(driver, "sreekar","Root-123","1001558251","Sreekar","Sandri","01/01/1992","6824149606","sreekar@hero.com",drivingLicenseString,"India mein ghar hai");
	driver.findElement(By.xpath(prop.getProperty("Lnk_UpdateProfile"))).click();
	String dl=driver.findElement(By.xpath(prop.getProperty("Txt_DrivingLicense"))).getAttribute("value");
	assertEquals(drivingLicense,Integer.parseInt(dl));
	driver.findElement(By.xpath(prop.getProperty("Btn_ClickHeretoLogin"))).click();
	
	//HA_BF_book (driver, "Biswa", "Nanda", "Arlington, TX", "4567098756781234", "VISA", "August", "2021", "234");
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
