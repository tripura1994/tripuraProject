package com.appium.testing.mobileautomation;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Camera
{
    private AndroidDriver<?> driver;
    Dimension size; 

    @SuppressWarnings("rawtypes")
	@Test
    public void test1() throws Exception{

        DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("deviceName", "A2QDU17112001306");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("network", ".");
		capabilities.setCapability("full-reset", "true");
        capabilities.setCapability("appPackage", "com.motorola.camera");
        capabilities.setCapability("appActivity","com.motorola.camera.Camera");

        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities) {
            };

           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           Thread.sleep(5000);
           driver.findElement(By.id("com.android.packageinstaller:id/permission_deny_button")).click();
           driver.pressKeyCode(AndroidKeyCode.BACK);
           
           driver.findElement(By.id("com.motorola.camera:id/button2")).click();
           WebElement ele = driver.findElement(By.id("com.motorola.camera:id/main"));
           TouchAction tapElement = new TouchAction(driver);
      	   tapElement.tap(ele);
      	   tapElement.release().perform();
       	   size=driver.manage().window().getSize();
      	   System.out.println("Size of the Screen :"+size);
           int x_start=(int)(size.width*0.60);
           int x_end=(int)(size.width*0.30);
           int y=130;
           driver.swipe(x_start,y,x_end,y,4000);
           WebElement e= driver.findElement(By.className("android.widget.FrameLayout"));
           Dimension size = driver.manage().window().getSize();
			int x0 = (int) (size.getWidth()*0.5);
			int y0 = (int) (size.getHeight()*0.5);
			System.out.println(x0+" "+y0);
		//	driver.zoom(100, 500);
           driver.zoom(e);
           Thread.sleep(5000);
           driver.pinch(e);
           Thread.sleep(5000);
        }catch(Exception ex) {
            System.out.println(ex.toString());


        }finally {
            //quit the browser
            driver.quit();
        }

    }
}