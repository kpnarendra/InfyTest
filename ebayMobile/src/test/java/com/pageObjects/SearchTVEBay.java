/**
 * 
 */
package com.pageObjects;

import org.openqa.selenium.By;

import com.helper.SupportingFunctions;
import com.helper.wrapperActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author narendrakp
 *
 */
public class SearchTVEBay extends wrapperActions  {

	//public AndroidDriver driver;
	SupportingFunctions genFunction = new SupportingFunctions(driver);
	
	By searchBox = By.id("com.ebay.mobile:id/search_box");
	By searchText = By.id("com.ebay.mobile:id/search_src_text");
	By searchSave = By.id("com.ebay.mobile:id/text_slot_1");
	
	public SearchTVEBay(AndroidDriver driver){
		super(driver);
	}
	
	//Enter search string in the search text box and press enter.
	public void searchInchTV(String searchStr){
		checkBeforeClick(searchBox);
		sendText(searchText,genFunction.fetchProperty(searchStr));
		pressEnterKey();
	}
	
	//A banner will is intermitently displayed to save the search in favourates.
	//Handle the banner to be clicked only if the element is visible.
	public void tapOnSaveSearch()
	{
		checkBeforeClick(searchSave);
	}
	
	
}
