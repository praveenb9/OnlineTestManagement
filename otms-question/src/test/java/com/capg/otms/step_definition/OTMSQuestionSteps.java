package com.capg.otms.step_definition;

import com.capg.otms.baseclass.Library;
import com.capg.otms.selenium_reusablefuntion.SeleniumUtility;

import comcapg.otms.pages.OTMSQuestionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OTMSQuestionSteps extends Library{
	
	OTMSQuestionPage questionPage;
	SeleniumUtility utility;
	
	@Given("To Select the Question Operation")
	public void to_Select_the_Question_Operation() {
	   questionPage=new OTMSQuestionPage(driver);
	   questionPage.OpenQuestionOperations();
	   logger.info("Opened Question Operations");
	}

	@When("To Open Add Question")
	public void to_Open_Add_Question() {
	    questionPage=new OTMSQuestionPage(driver);
	    questionPage.questionAdd();
	    logger.info("Opened Add Question");
	}

	@Then("To Take Screenshot and Title")
	public void to_Take_Screenshot_and_Title() {
	   utility=new SeleniumUtility(driver);
	   utility.to_take_screenshot("addQuestion");
	   logger.info("Taken Screenshot of Add Question");
	}

	@Then("To Click on Back")
	public void to_Click_on_Back() {
	    questionPage=new OTMSQuestionPage(driver);
	    questionPage.addQuestionBack();
	    logger.info("Clicked on Back In AddQuestion ");
	}

	@Then("To Click on List Of Questions")
	public void to_Click_on_List_Of_Questions() {
	    questionPage=new OTMSQuestionPage(driver);
	    questionPage.OpenQuestionList();
	    logger.info("Opened In Question List");
	}
	@Then("To Take QuestionList Screenshot")
	public void to_Take_QuestionList_Screenshot() {
		utility=new SeleniumUtility(driver);
		   utility.to_take_screenshot("QuestionList");
		   logger.info("Taken Screenshot of  Question List");
	    
	}

	@Then("To Click on Back In QuestoinList")
	public void to_Click_on_Back_In_QuestoinList() {
		questionPage=new OTMSQuestionPage(driver);
	    questionPage.questionListBack();
	    logger.info("Clicked on Back In Question List");

	}
	@Then("To close The browser")
	public void to_close_The_browser() {
	   tearDown();
	   logger.info("Browser closed");
	}

}
