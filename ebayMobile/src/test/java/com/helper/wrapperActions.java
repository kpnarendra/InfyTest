/**
 * 
 */
package com.helper;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author narendrakp
 *
 */
public class wrapperActions extends SupportingFunctions{
	
	public wrapperActions(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}




	//public AndroidDriver driver;
	//SupportingFunctions genFunction = new SupportingFunctions(driver);

	
	

	public void clickElement(By ele)
	{
		driver.findElement(ele).click();
	}

}
