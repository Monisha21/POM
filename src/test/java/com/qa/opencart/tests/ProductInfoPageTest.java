package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.BasePackage.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	
	SoftAssert softassert = new SoftAssert();
	
	@BeforeClass
	public void productInfoSetup() {
		myaccountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyProductSearchResultCount() {
		searchresultpage = myaccountpage.doSearch("Macbook");
		int productResultsCount = searchresultpage.getProductResultsCount();
		Assert.assertTrue(productResultsCount == 3);
	}
	
	@Test
	public void verifyProductHeader() {
		searchresultpage = myaccountpage.doSearch("imac");
		productinfopage = searchresultpage.selectProductFromResults("iMac");
		String productheader = productinfopage.productheader();
		Assert.assertEquals(productheader, "iMac");
	}
	
	@Test
	public void verifyproductImages() {
		searchresultpage = myaccountpage.doSearch("MacBook");
		productinfopage = searchresultpage.selectProductFromResults("MacBook");
		int productImagesCount = productinfopage.productImagesCount();
		Assert.assertTrue(productImagesCount==4);
	}
	
	@Test
	public void verifySelectedProductMetaData() {
		searchresultpage = myaccountpage.doSearch("MacBook");
		productinfopage = searchresultpage.selectProductFromResults("MacBook");
		Map<String, String> actualProductMetaData = productinfopage.getProductInformation();
		actualProductMetaData.forEach((k,v) -> System.out.println(k + " : " + v));
		Assert.assertEquals(actualProductMetaData.get("name"), "MacBook123");
		softassert.assertEquals(actualProductMetaData.get("Brand"), "Apple");
		softassert.assertEquals(actualProductMetaData.get("Product Code"), "Product 16");
		softassert.assertEquals(actualProductMetaData.get("Reward Points"), "600");
		softassert.assertEquals(actualProductMetaData.get("Availability"), "In Stock");
		softassert.assertAll();
	}
	
	
	
}
