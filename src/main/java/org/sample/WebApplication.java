package org.sample;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class WebApplication {
	
	public static AndroidDriver driver;

	public static void main(String[] args) {
		 
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","9");
		cap.setCapability("deviceName","vivo 1727");
		cap.setCapability("udid","8d10ce32");
		cap.setCapability("appPackage","com.android.chrome");
		cap.setCapability("appActivity","com.google.android.apps.chrome.Main");
		
		URL url = new URL("http://0.0.0.0:4723");				// <<<-------------- remote id from the appium (appium version 2) or
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		// <<<-------------- remote id from the appium (appium version 1)
		
		driver = new AndroidDriver(url,cap);
		
		WebElement accept = driver.findElement(By.id("com.android.chrome:id/terms_accept"));
		accept.click();
		
		WebElement nothanks = driver.findElement(By.id("com.android.chrome:id/negative_button"));
		nothanks.click();
		
		WebElement home = driver.findElement(By.id("com.android.chrome:id/home_button"));
		home.click();
		
		// Xpath = //tagname[@attribute='value'] ---------> tagname ====>>> tag value
		WebElement searchbar = driver.findElement(By.xpath("//android.widget.EditTet[@index='0']"));
		searchbar.sendKeys("Inmakes Infotech");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
}
