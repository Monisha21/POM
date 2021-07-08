package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	//1. By locators
	//We use private only for achieving encapsulation as per POM design pattern
	//For accessing these private variables we need to use public methods
	
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbutton = By.xpath("//input[@value='Login']");
	private By forgotten_password_link = By.xpath("(//a[contains(text(),'Forgotten Password')])[1]");
	private By continuebutton = By.xpath("//a[@class='btn btn-primary']");
	private By searchbar = By.xpath("//input[@name='search']");
	private By searchbutton = By.xpath("//button[@class='btn btn-default btn-lg']");
	private By logo = By.xpath("//a[contains(text(),'Your Store')]");
	
	private By registerbutton = By.xpath("//a[@class='list-group-item' and contains(text(),'Register')]");
	
	
	//2. Constructors
	//Via constructor we will pass the driver to access all the elements in page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	//3. Page Actions > This will be public
	public String getLoginPageTitle() {
		return elementutils.waitForTitle(5, Constants.Login_Page_Title);
	}
	
	public String getLoginPageURL() {
		return elementutils.getPageUrl();
	}
	
	public boolean logoisDisplayed() {
		return elementutils.doIsDisplayed(logo);
	}
	
	public MyAccountPage doLogin(String us, String ps) {
		elementutils.doSendKeys(username, us);
		elementutils.doSendKeys(password, ps);
		elementutils.doClick(loginbutton);
		return new MyAccountPage(driver);
	}
	
	public void doSearch(String searchKeyword) {
		elementutils.doSendKeys(searchbar, searchKeyword);
		elementutils.doClick(searchbutton);
	}
	
	public RegistrationPage continueRegisterPage() {
		elementutils.doClick(continuebutton);
		return new RegistrationPage(driver);
	}
	
	public RegistrationPage navigateToRegisterPage() {
		elementutils.doClick(registerbutton);
		return new RegistrationPage(driver);
	}
	
}
