package org.sample;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg {
	
	public static AndroidDriver driver;

	
	@BeforeClass
	private void launchBrowser() throws MalformedURLException{
		 
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","9");
		cap.setCapability("deviceName","vivo 1727");
		cap.setCapability("udid","8d10ce32");
		cap.setCapability("appPackage","com.android.bbkcalculator");
		cap.setCapability("appActivity","com.android.bbkcalculator.Calculator");
		
		URL url = new URL("http://0.0.0.0:4723");				// <<<-------------- remote id from the appium (appium version 2) or
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		// <<<-------------- remote id from the appium (appium version 1)
		
		driver = new AndroidDriver(url,cap);
		
	}
	
	@BeforeMethod
	private void startDate() {
		Date d =new Date();
		System.out.println(d);

	}
	
	@Test
	private void tc1() {
		WebElement eight = driver.findElement(By.id("com.android.bbkcalculator:id/digit8"));
		eight.click();
		
		WebElement six = driver.findElement(By.id("com.android.bbkcalculator:id/digit6"));
		six.click();
		
	}
	
	@Test
	private void tc2() {
		WebElement cross = driver.findElement(By.id("com.android.bbkcalculator:id/mul"));
		cross.click();
	}
	
	@Test
	private void tc3() {
		WebElement one = driver.findElement(By.id("com.android.bbkcalculator:id/digit1"));
		one.click();
	}
	
	@Test
	private void tc4() {
		WebElement equal = driver.findElement(By.id("com.android.bbkcalculator:id/equal"));
		equal.click();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("./screenshot\\cal.png");
		FileUtils.copyFile(img,f);

	}
	
	
	@AfterMethod
	private void endDate() {
		Date d = new Date();
		System.out.println(d);

	}
	
	
	@AfterClass
	private void closeBrowser() {
		driver.quit();

	}
}
