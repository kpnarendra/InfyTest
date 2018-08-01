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
 *
 */
public class wrapperActions extends SupportingFunctions {

	public wrapperActions(AndroidDriver driver) {
		super(driver);
	}

	public void clickElement(By ele) {
		driver.findElement(ele).click();
	}

	public void sendText(By ele, String txt) {
		driver.findElement(ele).sendKeys(txt);
	}

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

	public void pressEnterKey() {
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}

	public void scrollToFindTextClick(String TVName) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()."
						+ "textContains(\"" + TVName + "\").instance(0))"))
				.click();
		;
	}

	public String readText(By ele) {
		return driver.findElement(ele).getText();
	}

	public void clearText(By ele) {
		driver.findElement(ele).clear();
	}

}
