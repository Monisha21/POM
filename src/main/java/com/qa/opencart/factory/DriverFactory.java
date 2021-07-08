package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Monisha
 * @Description Driver Factory will do Driver initialization and properties
 *        initialization
 */

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	
//	public static String highlight = null;
//
//	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * @param browsername
	 * @return This method will return Webdriver
	 */

	public WebDriver init_driver(String Browsername) {
		System.out.println("Browser name is  " + Browsername);

		if (Browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser Name is incorrect : " + Browsername);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url").trim());

		return driver;
	}

	/**
	 * 
	 * @return 
	 * @return Properties
	 * 
	 */
//	public Properties init_properties() {
//		FileInputStream fis = null;
//		prop = new Properties();
//
//		String environment = System.getProperty("environment"); // Used to call the environment name from command line
//		if (environment == null) {
//			try {
//				fis = new FileInputStream("./src/test/resources/Config/config.properties");
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//		} else {
//			try {
//
//				switch (environment) {
//				case "qa":
//					fis = new FileInputStream("./src/test/resources/Config/qa.config.properties");
//					break;
//				case "dev":
//					fis = new FileInputStream("./src/test/resources/Config/dev.config.properties");
//					break;
//				default:
//					break;
//				}
//
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//
//			try {
//				prop.load(fis);
//			} catch (FileNotFoundException e) {
//				System.out.println("File Not Found");
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return prop;
//	}
	
	
	
//	public static synchronized WebDriver getDriver() {
//		return tlDriver.get();
//	}
//
//	public String getScreenshot() {
//
//		// ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
//
//		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); String
//		 path = System.getProperty("user.dir") + "/Screenshots/" +
//		 System.currentTimeMillis() + ".png"; File destination = new File(path);
//		 try {
//			FileUtils.copyFile(source, destination);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} return path;
//
//	}
	
	
	
	public Properties init_properties() {
		FileInputStream fis = null;
		prop = new Properties();
		try {
			fis = new FileInputStream("./src/test/resources/Config/config.properties");
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
