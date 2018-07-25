package com.supportingfiles;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class VerifyEBayPurchase {

	public AndroidDriver driver;
	SupportingFunctions genFunction = new SupportingFunctions(driver);
	

	TvDetails selectedTVDetails = new TvDetails();
	
	By selectedTvId = By.id("com.ebay.mobile:id/textview_item_name");
	By selectedTvPrice = By.id("com.ebay.mobile:id/textview_item_price");	

	By searchAgain = By.id("com.ebay.mobile:id/menu_search");
	By searchBox = By.id("com.ebay.mobile:id/search_src_text"); 
	
	public VerifyEBayPurchase(AndroidDriver driver)
	{
		this.driver =driver;
	}
	
	
	public TvDetails returnTVPurchaseInfo(){
		System.out.println("Verify TV Purchase : TV Name - " +driver.findElement(selectedTvId).getText());
		System.out.println("Verify TV Purchase : TV Cost - " +driver.findElement(selectedTvPrice).getText());
		selectedTVDetails.setTvName(driver.findElement(selectedTvId).getText());
		selectedTVDetails.setTvCost(driver.findElement(selectedTvPrice).getText());
		return selectedTVDetails;
		
	}
	
	public void clickOnSearchAgain(){
		driver.findElement(searchAgain).click();
		driver.findElement(searchBox).clear();
	}
	 
}
