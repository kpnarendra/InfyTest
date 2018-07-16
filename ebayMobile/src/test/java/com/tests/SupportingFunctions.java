/**
 * 
 */
package com.tests;

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

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SupportingFunctions {

	File file = new File(System.getProperty("user.dir") + "/src/test/resources/data.properties");
	File app  =  new	File(System.getProperty("user.dir") + "/src/test/resources/com.ebay.mobile_v5.22.0.10-129_Android-5.0.apk");
	String propVal;
	public AndroidDriver driver;
	public Properties prop;

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


	public String fetchProperty(String propKey) {
		return prop.getProperty(propKey);

	}

	public void waitMethod(int waitTime) {

		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AndroidDriver setMobCapeabilities() throws InterruptedException, MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, fetchProperty("platformVersion"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, fetchProperty("platformName"));
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, fetchProperty("deviceName"));
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
		caps.setCapability(MobileCapabilityType.APP,app);
		caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, fetchProperty("appActivity"));
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, fetchProperty("appPackage"));
		
		
		Thread.sleep(5000);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4750/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitMethod(4);
		return driver;
	}

}
