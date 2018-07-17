/**
 * 
 */
package com.tests;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author narendrakp
 *
 */
public class SearchTVEBay {

	public AndroidDriver driver;
	SupportingFunctions genFunction = new SupportingFunctions(driver);
	
	By searchBox = By.id("com.ebay.mobile:id/search_box");
	By searchText = By.id("com.ebay.mobile:id/search_src_text");
	
	public SearchTVEBay(AndroidDriver driver){
		this.driver = driver;
	}
	
	void search55InchTV(){
		genFunction.waitMethod(5);
		driver.findElement(searchBox).click();
		driver.findElement(searchText).sendKeys(genFunction.fetchProperty("SearchString"));
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}
	
}
