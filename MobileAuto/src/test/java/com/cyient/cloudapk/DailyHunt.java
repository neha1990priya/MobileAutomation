package com.cyient.cloudapk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DailyHunt {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		   DesiredCapabilities caps = new DesiredCapabilities();
		      
		      // Set your access credentials
		      caps.setCapability("browserstack.user", "kushumranjankuna_wMi6zy");
		      caps.setCapability("browserstack.key", "ng1wWM8iNrKMBVs1SLFt");
		      
		      // Set URL of the application under test
		      caps.setCapability("app", "bs://20d9f1a717a8cf6edfa5446fef793b58146e5d8b");
		      
		      // Specify device and os_version for testing
		      caps.setCapability("device", "Xiaomi Redmi Note 9");
		      caps.setCapability("os_version", "10.0");
		        
		      // Set other BrowserStack capabilities
		      caps.setCapability("project", "First Java Project Daily Hunt");
		      caps.setCapability("build", "Java Android");
		      caps.setCapability("name", "first_test_news");
		        
		      
		      // Initialise the remote Webdriver using BrowserStack remote URL
		      // and desired capabilities defined above
		        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
		            new URL("http://hub.browserstack.com/wd/hub"), caps);
	        driver.findElementByAndroidUIAutomator("UiSelector().text(\"English\")").click();
	        driver.findElementByAndroidUIAutomator("UiSelector().text(\"News\")").click();
	       // driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"Twitter\")").click();
	        driver.findElementByAndroidUIAutomator("UiSelector().text(\"Follow\")").click();
	      //scroll
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			while(driver.findElementsByXPath("//*[contains(@text,'Entertainment')]").size()==0)
			{
				Map<String,String> map=new HashMap<String, String>();
				map.put("command", "input touchscreen swipe 1007 1323 1007 1167");
				driver.executeScript("mobile:shell", map);
			}
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			driver.findElementByXPath("//*[contains(@text,'Entertainment')]").click();
	        
			
	        
	        Thread.sleep(5000);
	      // Invoke driver.quit() after the test is done to indicate that the test is completed.
	      driver.quit();
	    
	    

	}

}