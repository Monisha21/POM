package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class HomePage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	//By Locators

	
	//Constructors
	public void HomePage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	//Page Functions
	public String homepageTitle() {
		return elementutils.waitForTitle(5, Constants.Home_Page_Title);
	}
	
	public String homepageURL() {
		return elementutils.getPageUrl();
	}
	
	

}
