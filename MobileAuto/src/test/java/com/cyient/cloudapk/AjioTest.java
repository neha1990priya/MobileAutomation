package com.cyient.cloudapk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AjioTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
	      
	      // Set your access credentials
	      caps.setCapability("browserstack.user", "nehapriya_48cnks");
	      caps.setCapability("browserstack.key", "j5Uyt6bcP1r6A3iwgXVa");
	      
	      // Set URL of the application under test
	      caps.setCapability("app", "bs://56a759054e777b6cfdb18606740398a42c39538e");
	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "Google Pixel 3");
	      caps.setCapability("os_version", "9.0");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "First Java Project Ajio");
	      caps.setCapability("build", "Java Android Neha");
	      caps.setCapability("name", "first_test_neha");
	        
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(
	            new URL("http://hub.browserstack.com/wd/hub"), caps);
	        
     
	        
	        driver.findElementByXPath("//*[@text='Account']").click();
	        
	        driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"Sign in\")").click();
	        
	        Thread.sleep(1500);
	        
	        driver.findElementByXPath("//*[@text='Skip']").click();
	       
	        
	        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			while(driver.findElementsByXPath("//*[contains(@text,'AJIO Own Sale Policy ')]").size()==0) {
				Map<String, String> map = new HashMap <String,String> ();
				map.put("command", "input touchscreen swipe 1007 1323 1007 1167");
				driver.executeScript("mobile:shell", map);
				
			}
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"AJIO Own Sale Policy \")").click();
			
	        
	      
	       // Invoke driver.quit() after the test is done to indicate that the test is completed.
	        Thread.sleep(1500);
	      driver.quit();
	    
	    }
	      
	  

	}


