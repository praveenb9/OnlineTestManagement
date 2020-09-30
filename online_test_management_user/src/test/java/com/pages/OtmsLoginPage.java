package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtmsLoginPage {

	public OtmsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userName")
	WebElement userNameText;
	@FindBy(id = "password")
	WebElement userPasswordText;
	@FindBy(xpath = "/html/body/app-root/div/div/main/app-login/div/body/div/form/div[3]/button" )
	WebElement loginButton;
	
	public void LoginUser(String username,String password) {
		userNameText.sendKeys(username);
		userPasswordText.sendKeys(password);
	}
	public void Submit() {
		loginButton.click();
		
	}
}
