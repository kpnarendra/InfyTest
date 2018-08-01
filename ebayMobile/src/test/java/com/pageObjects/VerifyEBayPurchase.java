package com.pageObjects;

import org.openqa.selenium.By;

import com.helper.SupportingFunctions;
import com.helper.wrapperActions;

import io.appium.java_client.android.AndroidDriver;

public class VerifyEBayPurchase extends wrapperActions {

	

	TvDetails selectedTVDetails = new TvDetails();
	
	By selectedTvId = By.id("com.ebay.mobile:id/textview_item_name");
	By selectedTvPrice = By.id("com.ebay.mobile:id/textview_item_price");	

	By searchAgain = By.id("com.ebay.mobile:id/menu_search");
	By searchBox = By.id("com.ebay.mobile:id/search_src_text"); 
	
	public VerifyEBayPurchase(AndroidDriver driver)
	{
		super(driver);
		
	}
	
	//Read and return the details of the TV.
	// Use getter and setter methods to retereive and store the data of TvDetails.
	public TvDetails returnTVPurchaseInfo(){
		System.out.println("Verify TV Purchase : TV Name - " + readText(selectedTvId));
		System.out.println("Verify TV Purchase : TV Cost - " + readText(selectedTvPrice));
		selectedTVDetails.setTvName(readText(selectedTvId));
		selectedTVDetails.setTvCost(readText(selectedTvPrice));
		return selectedTVDetails;
	}
	
	//This method is to navigate in app so that another search can be done.
	public void clickOnSearchAgain(){
		clickElement(searchAgain);
		clearText(searchBox);
	}
	 
}
