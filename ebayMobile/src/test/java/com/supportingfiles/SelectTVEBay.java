/**
 * 
 */
package com.supportingfiles;


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author narendrakp
 *
 */
public class SelectTVEBay {
	
	public AndroidDriver driver;
	
	SupportingFunctions genFunction = new SupportingFunctions(driver);
	
	public SelectTVEBay(AndroidDriver driver) {
		this.driver = driver;
	}

	//Scroll down to find the TV selected and click on the link to view TV details screen. 
	public void findTVByName(String TV1) 
	{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()."
				+ "textContains(\"" +TV1+ "\").instance(0))")).click();;
	}
}
