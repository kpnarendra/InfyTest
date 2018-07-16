package com.tests;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class VerifyEBayPurchase {

	public AndroidDriver driver;
	SupportingFunctions genFunction = new SupportingFunctions(driver);
	

	TvDetails selectedTVDetails = new TvDetails();
	
	By selectedTvId = By.id("com.ebay.mobile:id/textview_item_name");
	By selectedTvPrice = By.id("com.ebay.mobile:id/textview_item_price");	
	
	
	public VerifyEBayPurchase(AndroidDriver driver)
	{
		this.driver =driver;
	}
	public TvDetails returnTVPurchaseInfo(){
		genFunction.waitMethod(4);
		System.out.println("Verify TV Purchase : TV Name - " +driver.findElement(selectedTvId).getText());
		System.out.println("Verify TV Purchase : TV Cost - " +driver.findElement(selectedTvPrice).getText());
		selectedTVDetails.setTvName(driver.findElement(selectedTvId).getText());
		selectedTVDetails.setTvCost(driver.findElement(selectedTvPrice).getText());
		
		return selectedTVDetails;
		
	}
}
