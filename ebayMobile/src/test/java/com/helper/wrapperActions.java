/**
 * 
 */
package com.helper;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author narendrakp
 * This class contains generic wrapper methods that is used in all page objects.
 * Click, sendkeys, press enter key, read text, clear text, scroll down to find text and click. 
 */
public class wrapperActions extends SupportingFunctions {

	
	public wrapperActions(AndroidDriver driver) {
		super(driver);
	}
	//Method used to Click an element.
	public void clickElement(By ele) {
		driver.findElement(ele).click();
	}
	//Method used to Send txt 
	public void sendText(By ele, String txt) {
		driver.findElement(ele).sendKeys(txt);
	}
	//Method to Check if element is avalable and then click.
	public void checkBeforeClick(By ele) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (!driver.findElements(ele).isEmpty())
			driver.findElement(ele).click();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(fetchProperty("waitTime")), TimeUnit.SECONDS);

	}

	/*
	 * public void checkBeforeClick(By ele) {
	 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); try{
	 * driver.findElement(ele).click(); }catch (NoSuchElementException e){
	 * 
	 * }finally{
	 * driver.manage().timeouts().implicitlyWait(Long.parseLong(fetchProperty(
	 * "waitTime")), TimeUnit.SECONDS); }
	 * }
	 */

	//Method to send ENTER key
	public void pressEnterKey() {
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}

	//Method to scroll down and find a text string and click when the string is found.
	public void scrollToFindTextClick(String TVName) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()."
						+ "textContains(\"" + TVName + "\").instance(0))"))
				.click();
		;
	}

	//Method to read text
	public String readText(By ele) {
		return driver.findElement(ele).getText();
	}

	//Method to clear text
	public void clearText(By ele) {
		driver.findElement(ele).clear();
	}

}
