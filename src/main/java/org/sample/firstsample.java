package org.sample;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class firstsample {
	
	public static AndroidDriver driver;

	public static void main(String[] args) {
		 
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
		
		//			Find locators using appium Inspector application
		
		WebElement eight = driver.findElement(By.id("com.android.bbkcalculator:id/digit8"));
		eight.click();
		
		WebElement add = driver.findElement(By.id("com.android.bbkcalculator:id/plus"));
		add.click();
		
		WebElement five = driver.findElement(By.id("com.android.bbkcalculator:id/digit5"));
		five.click();
		
		WebElement equal = driver.findElement(By.id("com.android.bbkcalculator:id/equal"));
		equal.click();
	}
}
