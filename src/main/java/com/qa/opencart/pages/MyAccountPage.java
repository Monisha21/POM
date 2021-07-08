package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class MyAccountPage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	//By locators
	
	private By my_account_header = By.xpath("//h2[contains(text(),'My Account')]");
	private By my_orders_header = By.xpath("//h2[contains(text(),'My Orders')]");
	private By my_affiliate_accounts_header = By.xpath("//h2[contains(text(),'My Affiliate Account')]");
	private By Newsletter_header = By.xpath("//h2[contains(text(),'Newsletter')]");
	private By all_links_from_headers = By.cssSelector("div#content a");
	private By logout = By.xpath("//a[@class = 'list-group-item' and contains(text(),'Logout')]");
	private By Searchtab = By.xpath("//input[@name='search']");
	private By searchbutton = By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");
	
	//Constructors
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	//Page Functions
	public String myAccountsPageTitle() {
		return elementutils.waitForTitle(5, Constants.My_account_page_title);
	}
	
	public String myAccountsPageURL() {
		return elementutils.getPageUrl();
	}
	
	public String myAccountHeader() {
		return elementutils.doGetText(my_account_header);
	}
	
	public String myOrdersHeader() {
		return elementutils.doGetText(my_orders_header);
	}
	
	public String myAffiliateAccountHeader() {
		return elementutils.doGetText(my_affiliate_accounts_header);
	}
	
	public String NewsletterHeader() {
		return elementutils.doGetText(Newsletter_header);
	}
	
	public ArrayList<String> getAllLinksFromHeaders() {
		ArrayList<String> accSectionListtext = new ArrayList<String>();
		List<WebElement> accSectionList = elementutils.waitForVisibilityOfElements(all_links_from_headers, 5);
		for (WebElement e : accSectionList) {
			accSectionListtext.add(e.getText());
		}
		Collections.sort(accSectionListtext);
		return accSectionListtext;
	}
	
	public SearchResultPage doSearch(String productname) {
		elementutils.doSendKeys(Searchtab, productname);
		elementutils.doClick(searchbutton);
		return new SearchResultPage(driver);
	}
	
	public LogoutPage dologout() {
		elementutils.doClick(logout);
		return new LogoutPage(driver);
	}
	
}
