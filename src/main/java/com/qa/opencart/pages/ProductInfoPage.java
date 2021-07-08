package com.qa.opencart.pages;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	//By locators
	private By productheader = By.cssSelector("div#content h1");
	private By productimages = By.cssSelector("ul.thumbnails li img");
	private By productmetadata = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productpricedata = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quatity = By.id("input-quantity");
	private By addtocartbutton = By.id("button-cart");
	private By addtocartsuccessmessage = By.cssSelector("div.alert.alert-success.alert-dismissible");
	
	
	//Constructors
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	//Page functions
	
	public String productheader() {
		return elementutils.doGetText(productheader);
	}
	
	public int productImagesCount() {
		return elementutils.getElements(productimages).size();
	}
	
	
	/**
	 * This method will collect product Meta data and pricing data information in the form of Hashmaps
	 * @return 
	 * 
	 */
	public HashMap<String, String> getProductInformation() {
		HashMap<String, String> productinfomap = new HashMap<String, String>();
		productinfomap.put("name", productheader());
		
		//To store the meta data in hashmap
		List<WebElement> productmetadatalist = elementutils.getElements(productmetadata);
			for(WebElement e : productmetadatalist) {
				String metadata[] = e.getText().split(":");
				String metaKey = metadata[0].trim();
				String metaValue = metadata[1].trim();
				productinfomap.put(metaKey, metaValue);
			}
			
		//To store the meta price data in hashmap
//		List<WebElement> productpricedatalist = elementutils.getElements(productpricedata);
//		for(WebElement e : productpricedatalist) {
//			String[] metaprice = e.getText().split(":");
//			String metaKey = metaprice[0].trim();
//			String metaValue = metaprice[1].trim();
//			productinfomap.put(metaKey, metaValue);
//		}
		
		return productinfomap;
	}
	
	public void selectQuantity(String quantity) {
		elementutils.doSendKeys(quatity, quantity);
	}
	
	public void addToCart() {
		elementutils.doClick(addtocartbutton);
	}

	
	public String addToCartSuccessMessage() {
		return elementutils.doGetText(addtocartsuccessmessage);
	}
}
