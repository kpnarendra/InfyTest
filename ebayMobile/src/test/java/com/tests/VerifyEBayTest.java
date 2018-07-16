/**
 * 
 */
package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.tests.*;
import io.appium.java_client.android.AndroidDriver;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

/**
 * @author narendrakp
 * @param <SupportingFunctions>
 *
 */
public class VerifyEBayTest {



	
	public AndroidDriver driver;
	SupportingFunctions genFunction = new SupportingFunctions(driver);
	LoginPageEBay loginToEBay ;
	SearchTVEBay searchTV;
	SelectTVEBay selectedTV; 
	VerifyEBayPurchase verifyTVDetails;
	TvDetails purchaseDetails;
	
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

	@Test(priority = 1)
	public void testLoginToEBay() {
		genFunction.waitMethod(8);
		loginToEBay = new LoginPageEBay(driver);
		loginToEBay.loginEBay();
	}
	
	@Test(priority = 2 , dependsOnMethods = "testLoginToEBay")
	public void searchTV(){
		genFunction.waitMethod(5);
		searchTV = new SearchTVEBay(driver);
		searchTV.search55InchTV();
		genFunction.waitMethod(5);
	}
	
	@Test(priority = 3 , dependsOnMethods = {"testLoginToEBay","searchTV"})
	public void getTV(){
		genFunction.waitMethod(5);
		selectedTV = new SelectTVEBay(driver);
		selectedTV.searchAndSelectTV(genFunction.fetchProperty("TVSelected_1"));
	}
	
	@Test(priority = 4 , dependsOnMethods = {"testLoginToEBay","searchTV","getTV"})
	public void verifyTVSelected(){
		genFunction.waitMethod(5);
		verifyTVDetails = new VerifyEBayPurchase(driver);
		purchaseDetails = verifyTVDetails.returnTVPurchaseInfo();
		assertEquals(purchaseDetails.getTvName(),genFunction.fetchProperty("TVName_1")," The TV names should match");
		assertEquals(purchaseDetails.getTvCost(),genFunction.fetchProperty("TVCost_1"), " The TV Cost should match");
		System.out.println("TV Name is "+purchaseDetails.getTvName()+ " and TV Costs AUD " + purchaseDetails.getTvCost());
	}
	
	@AfterClass
	public void tearDown(){
		
		driver.quit();
	}

}
