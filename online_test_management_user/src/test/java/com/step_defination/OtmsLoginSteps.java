package com.step_defination;

import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base_class.Library;
import com.pages.OtmsLoginPage;
import com.selenium_reuseablefunction.SeleniumUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OtmsLoginSteps extends Library{
	
	OtmsLoginPage otmsLoginPage;
	SeleniumUtility seleniumUtlity;
	
	@Given("To launch the browser and navigate to url")
	public void to_launch_the_browser_and_navigate_to_url() {
	    browserSetUp();
	    logger.info("Browser launched");
	}

	@When("To enter Username and Password")
	public void to_enter_Username_and_Password() {
	   otmsLoginPage =new OtmsLoginPage(driver);
	   otmsLoginPage.LoginUser(properties.getProperty("username"), properties.getProperty("password"));
	   logger.info("Entered userName and password");
	}

	@Then("To click the Submit button")
	public void to_click_the_Submit_button() {
	   otmsLoginPage=new OtmsLoginPage(driver);
	   otmsLoginPage.Submit();
	  	   logger.info("login button clicked ");
	}

	@Then("To click popup button")
	public void to_click_popup_button() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.alertIsPresent());
	   Alert alert=driver.switchTo().alert();
	   String msg=driver.switchTo().alert().getText();
	   alert.accept();
	   logger.info(msg);
	   
	}

	@Then("To take the ScreenShot and the title")
	public void to_take_the_ScreenShot_and_the_title() {
	    seleniumUtlity =new SeleniumUtility(driver);
	    seleniumUtlity.to_take_screenshot("loginpage");
	    seleniumUtlity.getTitle();
	    logger.info("Taken screenshot of loging page and title is obtained");
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
	    tearDown();
	    logger.info("The browser is closed");
	}




}
