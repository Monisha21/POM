package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BasePackage.BaseTest;
import com.qa.opencart.utils.ExcelUtils;

public class RegistrationPageTest extends BaseTest{
	
	
	@BeforeClass
	public void registrationPageSetup() {
		loginpage.navigateToRegisterPage();
	}
	
	@Test(dataProvider = "getRegisterdata")
	public void verifyUserRegistration(String firstname, String lastname, String email, String telephone, String password, String subscribe) {
		Assert.assertTrue(registrationpage.doRegister(firstname, lastname, email, telephone, password, subscribe));
	}
	
	@DataProvider
	public Object[][] getRegisterdata() {
		Object[][] registrationData = ExcelUtils.getTestData("Register");
		return registrationData;
	}
	
	
	


}
