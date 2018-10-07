package com.appium.testing.mobileautomation;


import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Flipkart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		WebDriver driver;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "A2QDU17112001306");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("network", ".");
		capabilities.setCapability("full-reset", "true");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");

		try
		{
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			Thread.sleep(5000);			
			driver.findElement(By.id("com.flipkart.android:id/btn_skip")).click();
			//click the menu button
			List<WebElement> menuButton = driver.findElements(By.className("android.widget.ImageButton"));
			menuButton.get(0).click();			
			
			//click My Account optionl
			driver.findElement(By.xpath("//android.widget.TextView[@text = 'My Account']")).click();
			
			//Enter Email ID
			WebElement usernameTextbox = driver.findElement(By.id("com.flipkart.android:id/mobileNo"));
			usernameTextbox.clear();
			usernameTextbox.sendKeys("test@gmail.com");
			
			//Enter Password
			driver.findElement(By.id("com.flipkart.android:id/et_password")).sendKeys("test@123");
			
			//Click Sign-In
			driver.findElement(By.id("com.flipkart.android:id/btn_mlogin")).click();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}