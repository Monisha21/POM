package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class SearchResultPage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	//By Locators
	private By searchitemresult = By.cssSelector("div.product-thumb");
	private By resultitems = By.cssSelector("div.product-thumb h4 a");
	
	
	//Constructors
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	
	//Page Actions
	public int getProductResultsCount() {
		return elementutils.getElements(searchitemresult).size();
	}
	
	public ProductInfoPage selectProductFromResults(String productname) {
		List<WebElement> resultitemslist = elementutils.getElements(resultitems);
		System.out.println("Total No of items displayed for  " + productname + "is  " + resultitemslist.size());
		for (WebElement e : resultitemslist) {
			if (e.getText().equals(productname)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	

}
