package com.step_defination;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base_class.Library;
import com.pages.OtmsRegisterPage;
import com.selenium_reuseablefunction.SeleniumUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OtmsRegisterSteps extends Library {

	OtmsRegisterPage otmsRegisterPage;
	SeleniumUtility seleniumUtility;
	
	
	@Given("To open browser and navigate")
	public void to_open_browser_and_navigate() {
	    browserSetUp();
	    logger.info("Browser launched");
	}

	@When("To click singup button")
	public void to_click_singup_button() {
	 otmsRegisterPage=new OtmsRegisterPage(driver);
	 otmsRegisterPage.Signup();
	 logger.info("signup button got clicked");
	}

	@Then("To enter username and password and select type of user")
	public void to_enter_username_and_password_and_select_type_of_user() {
		otmsRegisterPage=new OtmsRegisterPage(driver);
		otmsRegisterPage.RegisterUser(properties.getProperty("userName"), properties.getProperty("passwordTxt"));
		logger.info("user name and password entered");
	   
	}

	@Then("To click the register button")
	public void to_click_the_register_button() {
	    otmsRegisterPage=new OtmsRegisterPage(driver);
	    otmsRegisterPage.Register();
	    logger.info("register button got clicked");
	}

	@Then("The popup button clicking")
	public void the_popup_button_clicking() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.alertIsPresent());
	   Alert alert=driver.switchTo().alert();
	   String msg=driver.switchTo().alert().getText();
	   alert.accept();
	   logger.info(msg);
	   
	}
	@Then("To take screenShot and get title")
	public void to_take_screenShot_and_get_title() {
	    seleniumUtility=new SeleniumUtility(driver);
	    seleniumUtility.to_take_screenshot("resiter");
	    seleniumUtility.getTitle();
	    logger.info("the screen shot is taken and got title");
	}

	@Then("To close the browser again")
	public void to_close_the_browser_again() {
	    tearDown();
	    logger.info("The browser is closed");
	}
}
