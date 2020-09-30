package com.capg.otms.step_definition;



import com.capg.otms.baseclass.Library;
import com.capg.otms.selenium_reusablefuntion.SeleniumUtility;


import comcapg.otms.pages.OTMSLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OTMSLoginSteps extends Library{
	
	OTMSLoginPage loginPage;
	
	SeleniumUtility utility;
	@Given("To Launch the Browser and navigate to the Url")
	public void to_Launch_the_Browser_and_navigate_to_the_Url() {
	   browserSetUp();
	   logger.info("Browser Launched");
	}

	@When("To Enter Username and Password")
	public void to_Enter_Username_and_Password() {
	    loginPage=new OTMSLoginPage(driver);
	    loginPage.loginUser(properties.getProperty("username"), properties.getProperty("password"));
	    logger.info("Entered User Details");
	}

	@Then("To Click the Submit button")
	public void to_Click_the_Submit_button() {
	    loginPage= new OTMSLoginPage(driver);
	    loginPage.submit();
	    logger.info("Log In Successfull");
	 

	}

	@Then("To Take The Screenshot and Title")
	public void to_Take_The_Screenshot_and_Title() {
	   
	    utility=new SeleniumUtility(driver);
	    utility.to_take_screenshot("otmslogin");
	}

	
}
