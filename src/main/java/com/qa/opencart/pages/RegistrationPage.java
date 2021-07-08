package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	//By locators
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email_id = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribe_yes = By.xpath("//input[@type='radio' and @name='newsletter' and @value='1']");
	private By subscribe_no = By.xpath("//input[@type='radio' and @name='newsletter' and @value='0']");
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By continuebuttontosubmit = By.xpath("//input[@type='submit']");
	private By successmessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
	private By logoutButton = By.xpath("//a[@class='list-group-item' and contains(text(),'Logout')]");
	private By registerButton = By.xpath("//a[@class='list-group-item' and contains(text(),'Register')]");
	
	//Constructors => for accessing driver
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	//Pagefunctions
	public boolean doRegister(String firstname, String lastname, String email_id, String telephone, String password, String subscribe) {
		elementutils.doSendKeys(this.firstname, firstname);
		elementutils.doSendKeys(this.lastname, lastname);
		elementutils.doSendKeys(this.email_id, email_id);
		elementutils.doSendKeys(this.telephone, telephone);
		elementutils.doSendKeys(this.password, password);
		elementutils.doSendKeys(this.confirmPassword, password);
		
		if(subscribe.equals("yes")) {
			elementutils.doClick(subscribe_yes);
		}else {
			elementutils.doClick(subscribe_no);
		}
		
		elementutils.doClick(checkbox);
		elementutils.doClick(continuebuttontosubmit);
		
		String successmessagetext = elementutils.waitForElementVisible(successmessage, 5).getText();
		System.out.println("Account got created successfully with the message -->  " + successmessagetext);
		if(successmessagetext.contains(Constants.Register_Success_Message)) {
			elementutils.doClick(logoutButton);
			elementutils.doClick(registerButton);
			return true;
		}
		return false;
	}
	

}
