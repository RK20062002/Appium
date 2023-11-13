package org.sample;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Properties_File {

	public static AndroidDriver driver;

	@Test
	private void tc1() throws IOException, AWTException{
		 
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
		
		WebElement add = driver.findElement(By.xpath(property.getProperty("add")));
		add.click();
		
		WebElement name = driver.findElement(By.xpath(property.getProperty("name")));
		name.sendKeys(property.getProperty("phName"));
		
		WebElement phone = driver.findElement(By.xpath(property.getProperty("phone")));
		phone.sendKeys(property.getProperty("phNumber"));
		
		WebElement save = driver.findElement(By.xpath(property.getProperty("save")));
		save.click();		
	}
		
}
