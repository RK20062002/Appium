package org.sample;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class ExtentReport {

	public static AndroidDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeSuite
	private void tc1() throws IOException, AWTException{
		
		htmlreport = new ExtentHtmlReporter("contactreport.html");  //    HTML REPORT
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		
		test = extent.createTest("Android","contact application");   // 	LOG EVENT
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Software Testing\\Eclipse_Commiters\\Appium_Project\\Property Files\\config.properties");
		property.load(fis);
		
		
		cap.setCapability("platformName", property.getProperty("platformName"));
		cap.setCapability("platformVersion", property.getProperty("platformVersion"));
		cap.setCapability("deviceName", property.getProperty("deviceName"));
		cap.setCapability("udid", property.getProperty("udid"));
		cap.setCapability("appPackage", property.getProperty("appPackage"));
		cap.setCapability("appActivity", property.getProperty("appActivity"));
		
		URL url = new URL("http://0.0.0.0:4723");				// <<<-------------- remote id from the appium (appium version 2) or
		URL url1 = new URL("http://0.0.0.0:4723/wd/hub");		// <<<-------------- remote id from the appium (appium version 1)
		
		driver = new AndroidDriver(url,cap);
		
		
		test.log(Status.INFO,"appium click the add Button"); // <<<<---------------------LOG(STATUS, DETAILS)
		WebElement add = driver.findElement(By.xpath(property.getProperty("add")));
		add.click();
		
		test.log(Status.PASS,"appium send the name");        // <<<<---------------------LOG(STATUS, DETAILS)
		WebElement name = driver.findElement(By.xpath(property.getProperty("name")));
		name.sendKeys(property.getProperty("phName"));
		
		test.log(Status.PASS,"appium send the ph_number");  // <<<<---------------------LOG(STATUS, DETAILS)
		WebElement phone = driver.findElement(By.xpath(property.getProperty("phone")));
		phone.sendKeys(property.getProperty("phNumber"));
		
		test.log(Status.PASS,"appium click the save Button");  // <<<<---------------------LOG(STATUS, DETAILS)
		WebElement save = driver.findElement(By.xpath(property.getProperty("save")));
		save.click();		
	}
	
	@Test(priority =1)
	private void tc2() {
		test.log(Status.PASS,"appium print the test case 2");  // <<<<---------------------LOG(STATUS, DETAILS)
		System.out.println("Test Case 2");
	}
	
	@Test(priority = 2)
	private void tc3() {
		test.log(Status.PASS,"appium print the test case 3");  // <<<<---------------------LOG(STATUS, DETAILS)
		System.out.println("Test Case 3");

	}
	
	@AfterSuite
	private void tc4() {
		test.log(Status.PASS,"appium close the application");  // <<<<---------------------LOG(STATUS, DETAILS)
		
		extent.flush();										   // <<<<---------------------FLUSH(WRITE EVERYTHING)
		driver.quit();
	}
}
