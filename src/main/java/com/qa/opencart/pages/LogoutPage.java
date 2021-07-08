package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class LogoutPage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	//By Locators
	By logoutHeader = By.xpath("//h1[contains(text(),'Account Logout')]");
	By logoutmessage1 = By.xpath("//p[contains(text(),'You have been logged off your account. It is now safe to leave the computer.')]");
	By logoutmessage2 = By.xpath("//p[contains(text(),'Your shopping cart has been saved, the items inside it will be restored whenever you log back into your account.')]");
	By continueButton = By.linkText("Continue");
	
	//Constructors
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	//PageFunctions
	public String getLogoutHeader() {
		return elementutils.doGetText(logoutHeader);
	}
	
	public String getLogoutMessage1() {
		return elementutils.doGetText(logoutmessage1);
	}
	
	
	public String getLogoutMessage2() {
		return elementutils.doGetText(logoutmessage2);
	}
	
	public HomePage clickContinue() {
		elementutils.doClick(continueButton);
		return new HomePage();
	}
	

}
