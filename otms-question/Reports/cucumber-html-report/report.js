$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/question.feature");
formatter.feature({
  "name": "To Test The OTMS Application",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "To Test the Login Functionality of OTMS",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "To Launch the Browser and navigate to the Url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSLoginSteps.to_Launch_the_Browser_and_navigate_to_the_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Enter Username and Password",
  "keyword": "When "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSLoginSteps.to_Enter_Username_and_Password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Click the Submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSLoginSteps.to_Click_the_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Take The Screenshot and Title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSLoginSteps.to_Take_The_Screenshot_and_Title()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To Test The Question Functionality of OTMS",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "To Select the Question Operation",
  "keyword": "Given "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSQuestionSteps.to_Select_the_Question_Operation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Open Add Question",
  "keyword": "When "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSQuestionSteps.to_Open_Add_Question()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Take Screenshot and Title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSQuestionSteps.to_Take_Screenshot_and_Title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Click on Back",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSQuestionSteps.to_Click_on_Back()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Click on List Of Questions",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSQuestionSteps.to_Click_on_List_Of_Questions()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Take QuestionList Screenshot",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSQuestionSteps.to_Take_QuestionList_Screenshot()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To Click on Back In QuestoinList",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSQuestionSteps.to_Click_on_Back_In_QuestoinList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To close The browser",
  "keyword": "Then "
});
formatter.match({
  "location": "com.capg.otms.step_definition.OTMSQuestionSteps.to_close_The_browser()"
});
formatter.result({
  "status": "passed"
});
});