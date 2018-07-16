/**
 * 
 */
package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import com.tests.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author narendrakp
 *
 */
public class SelectTVEBay {
	
	public AndroidDriver driver;
	
	SupportingFunctions genFunction = new SupportingFunctions(driver);
	
	By searchSave = By.id("com.ebay.mobile:id/text_slot_1");
	
	public SelectTVEBay(AndroidDriver driver) {
		this.driver = driver;
	}

	
	void tapOnSaveSearch()
	{
		driver.findElement(searchSave).click();
	}
	

	void findAndReturnTVName(String TV1) 
	{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()."
				+ "textContains(\"" +TV1+ "\").instance(0))")).click();;
		

	}
	
	public void searchAndSelectTV(String TV1){
		tapOnSaveSearch();
		findAndReturnTVName(TV1);
	}
	


}
