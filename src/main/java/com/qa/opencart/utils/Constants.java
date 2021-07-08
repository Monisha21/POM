package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	public static final String Login_Page_Title = "Account Login";
	public static final String Login_Page_URL = "https://s1.demo.opensourcecms.com/opencart/index.php?route=account/login";
	public static final String My_account_page_title = "My Account";
	public static final String My_Account_header = "My Account";
	public static final List<String> Expected_Links_From_MyAccount = 
																Arrays.asList("Edit your account information" , 
																						"Change your password",
																						"Modify your address book entries",
																						"Modify your wish list",
																						"View your order history",
																						"Downloads",
																						"Your Reward Points",
																						"View your return requests",
																						"Your Transactions",
																						"Recurring payments",
																						"Register for an affiliate account",
																						"Subscribe / unsubscribe to newsletter");
	
	public static final String Home_Page_Title = "Your Store";
	public static final String Logout_Page_Header = "Account Logout";
	
	public static final String Register_Success_Message = "Your Account Has Been Created!";
}
