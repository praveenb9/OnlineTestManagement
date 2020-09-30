$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/TestCases.feature");
formatter.feature({
  "name": "To test the otms application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To test the login function of otms",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "To launch the browser and navigate to url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.step_defination.OtmsLoginSteps.to_launch_the_browser_and_navigate_to_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To enter Username and Password",
  "keyword": "When "
});
formatter.match({
  "location": "com.step_defination.OtmsLoginSteps.to_enter_Username_and_Password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click the Submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsLoginSteps.to_click_the_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click popup button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsLoginSteps.to_click_popup_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To take the ScreenShot and the title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsLoginSteps.to_take_the_ScreenShot_and_the_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsLoginSteps.to_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To Test the signup function of otms",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "To open browser and navigate",
  "keyword": "Given "
});
formatter.match({
  "location": "com.step_defination.OtmsRegisterSteps.to_open_browser_and_navigate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click singup button",
  "keyword": "When "
});
formatter.match({
  "location": "com.step_defination.OtmsRegisterSteps.to_click_singup_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To enter username and password and select type of user",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsRegisterSteps.to_enter_username_and_password_and_select_type_of_user()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click the register button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsRegisterSteps.to_click_the_register_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The popup button clicking",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsRegisterSteps.the_popup_button_clicking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To take screenShot and get title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsRegisterSteps.to_take_screenShot_and_get_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To close the browser again",
  "keyword": "Then "
});
formatter.match({
  "location": "com.step_defination.OtmsRegisterSteps.to_close_the_browser_again()"
});
formatter.result({
  "status": "passed"
});
});