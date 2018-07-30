/**
 * 
 */
package com.supportingfiles;

/**
 * @author narendrakp
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SupportingFunctions {

	// Read data.properties file in resources where the test data is stored in the form of key value pairs. 
	File file = new File(System.getProperty("user.dir") + "/src/test/resources/data.properties");
	File app  =  new	File(System.getProperty("user.dir") + "/src/test/resources/com.ebay.mobile_v5.22.0.10-129_Android-5.0.apk");
	String propVal;
	// Android driver to send and receive device commands.
	public AndroidDriver driver;
	public Properties prop;

	// Constructor for setting android driver local variable and reading data.proprties file as key value pairs.
	public SupportingFunctions(AndroidDriver driver) {
		this.driver = driver;
		
		try {
			FileInputStream fileinput = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileinput);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(file + " is not found or may have readability issues.");
			System.exit(1);
		}
	}

	// Function to retrurn values supplying the key for the key value oairs defined in data.properties file.
	public String fetchProperty(String propKey) {
		return prop.getProperty(propKey);
	}

	//wait method - not used anywhere.
	public void waitMethod(int waitTime) {
		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Set desired capeabilities - install apk file for E Bay from resources folder, invoke android driver, set implicit time out for the driver.  
	public AndroidDriver setMobCapeabilities() throws InterruptedException, MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, fetchProperty("platformVersion"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, fetchProperty("platformName"));
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, fetchProperty("deviceName"));
		//caps.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, "30000");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
		caps.setCapability(MobileCapabilityType.APP,app);
		caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, fetchProperty("appActivity"));
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, fetchProperty("appPackage"));	
		Thread.sleep(5000);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4750/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(fetchProperty("waitTime")), TimeUnit.SECONDS);
		waitMethod(4);
		return driver;
	}

}
