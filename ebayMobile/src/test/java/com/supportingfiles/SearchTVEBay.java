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
	
	//Enter search string in the search text box and press enter.
	public void searchInchTV(String searchStr){
		if(!driver.findElements(searchBox).isEmpty())
		driver.findElement(searchBox).click();
		driver.findElement(searchText).sendKeys(genFunction.fetchProperty(searchStr));
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}
	
	//A banner will is intermitently displayed to save the search in favourates.
	//Handle the banner to be clicked only if the element is visible.
	public void tapOnSaveSearch()
	{
		if(!driver.findElements(searchSave).isEmpty())
		driver.findElement(searchSave).click();
	}
	
	
}
