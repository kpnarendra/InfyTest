/**
 * 
 */
package com.supportingfiles;

import org.openqa.selenium.By;

import com.supportingfiles.SupportingFunctions;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author narendrakp
 *
 */
public class LoginPageEBay {

	
	public AndroidDriver driver;
	String eBayUsn, eBayPwd;
	SupportingFunctions genFunction = new SupportingFunctions(driver);

	By signInBtn = By.id("com.ebay.mobile:id/button_sign_in");
	By loginName = By.id("com.ebay.mobile:id/edit_text_username");
//	By loginPwd = By.id("com.ebay.mobile:id/edit_text_password");
//	By loginPwd = By.id("com.ebay.mobile:id/et_temp");
	By loginPwd = By.id("com.ebay.mobile:id/password_container");
	By signInBtn2= By.id("com.ebay.mobile:id/button_sign_in");
	By noThanks = By.id("com.ebay.mobile:id/button_google_deny");

	
	public LoginPageEBay(AndroidDriver driver){
		this.driver = driver;
	}
	
	//Click on signin button when the ebay app is loaded.
	public void clickSignIn() {
		driver.findElement(signInBtn).click();		
	}

	//Log in to Ebay
	public void logInToEbay(){
		
		//Enter user name, User name is data is fetched from data.properties file.
			eBayUsn = genFunction.fetchProperty("userName");
			driver.findElement(loginName).sendKeys(eBayUsn);
		
		//Enter password, Password data is fetched from data.properties file.
			eBayPwd = genFunction.fetchProperty("password");
			driver.findElement(loginPwd).sendKeys(eBayPwd);
		
		//Click on signin button after entering user name and password. 
			driver.findElement(signInBtn2).click();
	}
	
	//Address a banner which suggests to use google authentication api. 
	//This is intermitant hence is handled to click if the element is found.
	public void eBayConfirm() {
		if(!driver.findElements(noThanks).isEmpty())
		driver.findElement(noThanks).click();
	}

}
