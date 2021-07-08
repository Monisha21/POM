package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.BasePackage.BaseTest;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
		String loginPageTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle,Constants.Login_Page_Title);
	}
	
	@Test
	public void loginPageURLTest() {
		String loginPageURL = loginpage.getLoginPageURL();
		Assert.assertEquals(loginPageURL, Constants.Login_Page_URL);
	}
	
	@Test 
	public HomePage loginTest() {
		loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		return new HomePage();
	}
	
//	@Test 
//	public void searchTest() {
//		loginpage.doSearch("MAC");
//	}

}
