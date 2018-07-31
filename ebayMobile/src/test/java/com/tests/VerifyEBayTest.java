/**
 * 
 */
package com.tests;

import org.testng.annotations.Test;

import com.helper.SupportingFunctions;
import com.pageObjects.LoginPageEBay;
import com.pageObjects.SearchTVEBay;
import com.pageObjects.SelectTVEBay;
import com.pageObjects.TvDetails;
import com.pageObjects.VerifyEBayPurchase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

/**
 * @author narendrakp
 * @param <SupportingFunctions>
 * This is testNG class which includes all the E Bay TestScenarios. 
 */
public class VerifyEBayTest {
	
	public AndroidDriver driver;
	SupportingFunctions genFunction = new SupportingFunctions(driver);
	LoginPageEBay loginToEBay ;
	SearchTVEBay searchTV;
	SelectTVEBay selectedTV; 
	VerifyEBayPurchase verifyTVDetails;
	TvDetails purchaseDetails;
	
	// Initiate device settings via desired capeabilities and read & load properties file as key value pairs. 
	// Install and launch E Bay application using desired capeabilities.
	@BeforeClass
	public void initiateDeviceSettings() {
		try {
			this.driver = genFunction.setMobCapeabilities();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("MalformedURLException while setting Mob Capeabilities!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("InterruptedException while setting Mob Capeabilities!!!");
		}
	}
	
	// Login to E Bay account with user name and password.
	@Test(priority = 1)
	public void testLoginToEBay() {
		loginToEBay = new LoginPageEBay(driver);
		loginToEBay.clickSignIn();
		loginToEBay.logInToEbay();
		loginToEBay.eBayConfirm();
	}
	
	//  Search TV using TV Search Instance 1 from data.properties file.
	@Test(priority = 2 , dependsOnMethods = "testLoginToEBay")
	public void testSearchTV1(){
		searchTV = new SearchTVEBay(driver);
		searchTV.searchInchTV("SearchString_1");
		searchTV.tapOnSaveSearch();
	}
	
	// Select TV Instance 1 from data.properties file.
	@Test(priority = 3 , dependsOnMethods = {"testLoginToEBay","testSearchTV1"})
	public void testGetTV1(){
		selectedTV = new SelectTVEBay(driver);
		selectedTV.findTVByName(genFunction.fetchProperty("TVSelected_1"));
	}
	
	// Compare the TV Name and cost.
	@Test(priority = 4 , dependsOnMethods = {"testLoginToEBay","testSearchTV1","testGetTV1"})
	public void testVerifyTVSelected1(){
		verifyTVDetails = new VerifyEBayPurchase(driver);
		purchaseDetails = verifyTVDetails.returnTVPurchaseInfo();
		assertEquals(purchaseDetails.getTvName(),genFunction.fetchProperty("TVName_1")," The TV names should match");
		assertEquals(purchaseDetails.getTvCost(),genFunction.fetchProperty("TVCost_1"), " The TV Cost should match");
		System.out.println("TV Name is "+purchaseDetails.getTvName()+ " and TV Costs " + purchaseDetails.getTvCost());
		verifyTVDetails.clickOnSearchAgain();
	}
	
	// Search TV using TV Search Instance 1 from data.properties file.
	@Test(priority = 5 , dependsOnMethods = "testLoginToEBay")
	public void testSearchTV2(){
		searchTV = new SearchTVEBay(driver);
		searchTV.searchInchTV("SearchString_2");
		searchTV.tapOnSaveSearch();
	}
	
	// Select TV Instance 1 from data.properties file.
	@Test(priority = 6 , dependsOnMethods = {"testLoginToEBay","testSearchTV2"})
	public void testGetTV2(){
		selectedTV = new SelectTVEBay(driver);
		selectedTV.findTVByName(genFunction.fetchProperty("TVSelected_2"));
	}
	
	// Compare the TV Name and cost.
	@Test(priority = 7 , dependsOnMethods = {"testLoginToEBay","testSearchTV2","testGetTV2"})
	public void testVerifyTVSelected2(){
		verifyTVDetails = new VerifyEBayPurchase(driver);
		purchaseDetails = verifyTVDetails.returnTVPurchaseInfo();
		assertEquals(purchaseDetails.getTvName(),genFunction.fetchProperty("TVName_2")," The TV names should match");
		assertEquals(purchaseDetails.getTvCost(),genFunction.fetchProperty("TVCost_2"), " The TV Cost should match");
		System.out.println("TV Name is "+purchaseDetails.getTvName()+ " and TV Costs AUD " + purchaseDetails.getTvCost());
	}
	
	//Close App and quit driver.
	@AfterClass
	public void tearDown(){
		driver.closeApp();
		driver.quit();
	}
}
