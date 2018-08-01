/**
 * 
 */
package com.pageObjects;


import com.helper.SupportingFunctions;
import com.helper.wrapperActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author narendrakp
 *
 */
public class SelectTVEBay extends wrapperActions {
	
	//public AndroidDriver driver;
	
	//SupportingFunctions genFunction = new SupportingFunctions(driver);
	
	public SelectTVEBay(AndroidDriver driver) {
		super(driver);
	}

	//Scroll down to find the TV selected and click on the link to view TV details screen. 
	public void findTVByName(String TVName) 
	{
		scrollToFindTextClick(TVName);
		
	}
}
