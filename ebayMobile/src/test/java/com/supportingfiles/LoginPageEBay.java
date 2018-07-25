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
	
	public void clickSignIn() {
		driver.findElement(signInBtn).click();
				
	}

	public void eBayEnterUserName() {
		eBayUsn = genFunction.fetchProperty("userName");
		driver.findElement(loginName).sendKeys(eBayUsn);
	}

	public void eBayEnterPassword() {
		eBayPwd = genFunction.fetchProperty("password");
		driver.findElement(loginPwd).sendKeys(eBayPwd);
	}

	public void clickSignInBtn2() {
		driver.findElement(signInBtn2).click();
	}
	
	public void eBayConfirm() {
		if(!driver.findElements(noThanks).isEmpty())
		driver.findElement(noThanks).click();
	}


}
