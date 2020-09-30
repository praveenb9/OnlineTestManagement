package com.testcases;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base_class.Library;
import com.pages.OtmsLoginPage;
import com.selenium_reuseablefunction.SeleniumUtility;

public class OtmsTestCases extends Library {
 
	OtmsLoginPage otmsLoginPage;
	SeleniumUtility seleniumUtility;
	
	@BeforeTest
	public void launchApp() {
		browserSetUp();
		logger.info("Browser launched");
	}
	@Test
	public void login() {
		otmsLoginPage=new OtmsLoginPage(driver);
		otmsLoginPage.LoginUser(properties.getProperty("username"), properties.getProperty("password"));
	
		logger.info("browser login successfully");
	}
	
	@AfterTest
	public void close() {
		seleniumUtility=new SeleniumUtility(driver);
		seleniumUtility.getTitle();
		seleniumUtility.to_take_screenshot("loginpage");
		tearDown();
		logger.info("closing the browser");
	}
}
