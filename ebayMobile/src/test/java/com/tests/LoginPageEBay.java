/**
 * 
 */
package com.tests;

import org.openqa.selenium.By;
import com.tests.SupportingFunctions;

import io.appium.java_client.MobileElement;
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
	By loginPwd = By.id("com.ebay.mobile:id/edit_text_password");
	By signInBtn2= By.id("com.ebay.mobile:id/button_sign_in");
	By noThanks = By.id("com.ebay.mobile:id/button_google_deny");

	
	public LoginPageEBay(AndroidDriver driver){
		this.driver = driver;
	}
	void clickSignIn() {
		driver.findElement(signInBtn).click();
				
	}

	void eBayEnterUserName() {
		eBayUsn = genFunction.fetchProperty("userName");
		driver.findElement(loginName).sendKeys(eBayUsn);
	}

	void eBayEnterPassword() {
		eBayPwd = genFunction.fetchProperty("password");
		driver.findElement(loginPwd).sendKeys(eBayPwd);
	}

	void clickSignInBtn2() {
		driver.findElement(signInBtn2).click();
	}
	
	void eBayConfirm() {
		driver.findElement(noThanks).click();
	}

	public void loginEBay() {
		clickSignIn();
		eBayEnterUserName();
		eBayEnterPassword();
		clickSignInBtn2();
		eBayConfirm();
	}

}
