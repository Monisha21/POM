package com.qa.opencart.BasePackage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	
	DriverFactory driverfactory;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public MyAccountPage myaccountpage;
	public LogoutPage logoutpage;
	public SearchResultPage searchresultpage;
	public ProductInfoPage productinfopage;
	public RegistrationPage registrationpage;
	
	@BeforeTest
	public void setUp() {
		driverfactory = new DriverFactory();
		prop = driverfactory.init_properties();
		driver = driverfactory.init_driver("chrome");
		loginpage = new LoginPage(driver);
		registrationpage = new RegistrationPage(driver);

		prop.getProperty("url");
		prop.getProperty("username", "password");

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
