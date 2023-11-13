package org.sample;

public class HybridApplication {
	
	public static AndroidDriver driver;

	public static void main(String[] args) {
		 
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","9");
		cap.setCapability("deviceName","vivo 1727");
		cap.setCapability("udid","8d10ce32");
		cap.setCapability("appPackage","com.myntra.android");
		cap.setCapability("appActivity","com.myntra.android.SplashActivity");
		
		URL url = new URL("http://0.0.0.0:4723");				// <<<-------------- remote id from the appium (appium version 2) or
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		// <<<-------------- remote id from the appium (appium version 1)
		
		driver = new AndroidDriver(url,cap);
		
		WebElement profile = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"tabButton_profile\"]"));
		profile.click();
		
		WebElement loginbtn = driver.findElement(By.xpath("//*[@text='LOG IN/SIGN UP']"));
		loginbtn.click();
		
		// Xpath = //tagname[@attribute='value'] ---------> tagname ====>>> tag value
		WebElement mobile = driver.findElement(By.xpath("//android.widget.EditTet[@content-desc=\"mobile\"]"));
		mobile.sendKeys("9791464242");
		
		driver.navigate().back();

		WebElement continuebtn = driver.findElement(By.xpath("//*[@text='CONTINUE']"));
		continuebtn.click();
		
}
