package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class OtmsRegisterPage  {

	public OtmsRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userName")
	WebElement userNameEnter;
	@FindBy(id = "userPassword")
	WebElement userPasswordEnter;
	@FindBy(xpath = "//*[@id=\'navbarSupportedContent\']/a")
	WebElement singupButton;
	@FindBy(xpath = "//*[@id=\"mat-radio-3\"]/label/div[2]")
	WebElement typeOfUser;
	@FindBy(xpath ="/html/body/app-root/div/div/main/app-register-user/div/div/form/button" )
	WebElement registerButton;
	
	public void RegisterUser(String userName,String passwordTxt) {
		userNameEnter.sendKeys(userName);
		userPasswordEnter.sendKeys(passwordTxt);
		typeOfUser.click();
	}
	public void Register() {
		registerButton.click();
	}
	public void Signup() {
		singupButton.click();
	}
}
