/**
 * 
 */
package com.pageObjects;

import org.openqa.selenium.By;
import com.helper.SupportingFunctions;
import com.helper.wrapperActions;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author narendrakp
 *
 */
public class LoginPageEBay extends wrapperActions {

	//public AndroidDriver driver;
	String eBayUsn, eBayPwd;
	SupportingFunctions genFunction = new SupportingFunctions(driver);

	By signInBtn = By.id("com.ebay.mobile:id/button_sign_in");
	By loginName = By.id("com.ebay.mobile:id/edit_text_username");
	// By loginPwd = By.id("com.ebay.mobile:id/edit_text_password");
	// By loginPwd = By.id("com.ebay.mobile:id/et_temp");
	By loginPwd = By.id("com.ebay.mobile:id/password_container");
	By signInBtn2 = By.id("com.ebay.mobile:id/button_sign_in");
	By noThanks = By.id("com.ebay.mobile:id/button_google_deny");

	public LoginPageEBay(AndroidDriver driver) {
		super(driver);
	}

	// Click on signin button when the ebay app is loaded.
	public void clickSignIn() {
		clickElement(signInBtn);
	}

	// Log in to Ebay
	public void logInToEbay() {

		// Enter user name, User name is data is fetched from data.properties
		// file.
		eBayUsn = genFunction.fetchProperty("userName");
		sendText(loginName, eBayUsn);

		// Enter password, Password data is fetched from data.properties file.
		eBayPwd = genFunction.fetchProperty("password");
		sendText(loginPwd, eBayPwd);

		// Click on signin button after entering user name and password.
		clickElement(signInBtn2);
	}

	// Address a banner which suggests to use google authentication api.
	// This is intermitant hence is handled to click if the element is found.
	public void eBayConfirm() {
		checkBeforeClick(noThanks);
	}

}
