package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.BasePackage.BaseTest;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.utils.Constants;

public class MyAccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		myaccountpage = new MyAccountPage(driver);
	}
	
	@Test (priority = 1)
	public void verifymyAccountsPageTitle() {
		String myAccountsPageTitle = myaccountpage.myAccountsPageTitle();
		Assert.assertEquals(myAccountsPageTitle, Constants.My_account_page_title);
	}
	
	@Test (priority = 2)
	public void verifyMyAccountsPageHeader() {
		String myAccountHeader = myaccountpage.myAccountHeader();
		Assert.assertEquals(myAccountHeader, Constants.My_Account_header);
	}
	
	
	@Test (priority = 3)
	public void verifyAllLinksfromMyAccountsPage() {
		ArrayList<String> allLinksFromHeaders = myaccountpage.getAllLinksFromHeaders();
		allLinksFromHeaders.stream().forEach(e -> System.out.println(e));
		Collections.sort(Constants.Expected_Links_From_MyAccount);
		Assert.assertEquals(allLinksFromHeaders, Constants.Expected_Links_From_MyAccount);
	}
	
	@Test (priority = 4)
	public void verifyLogout() {
		myaccountpage.dologout();
	}
	
	
	
	
	

}
