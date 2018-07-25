/**
 * 
 */
package com.supportingfiles;

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
	By searchSave = By.id("com.ebay.mobile:id/text_slot_1");
	
	public SearchTVEBay(AndroidDriver driver){
		this.driver = driver;
	}
	
	public void searchInchTV(String searchStr){
		//genFunction.waitMethod(5);
		if(!driver.findElements(searchBox).isEmpty())
		driver.findElement(searchBox).click();
		driver.findElement(searchText).sendKeys(genFunction.fetchProperty(searchStr));
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}
	
	public void tapOnSaveSearch()
	{
		if(!driver.findElements(searchSave).isEmpty())
		driver.findElement(searchSave).click();
	}
	
	
}
