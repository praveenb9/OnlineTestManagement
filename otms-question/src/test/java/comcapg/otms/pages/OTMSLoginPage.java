package comcapg.otms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capg.otms.baseclass.Library;

public class OTMSLoginPage extends Library{

	public OTMSLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "userName")
	WebElement usernameText;
	
	@FindBy(id = "password")
	WebElement passwordText;
	
	@FindBy(xpath = "/html/body/app-root/div/div/main/app-login/div/body/div/form/div[3]/button")
	WebElement loginButton;
	
	
	public void loginUser(String userName, String password) {
		
		usernameText.sendKeys(userName);
		passwordText.sendKeys(password);
	}
	
	public void ClickOnAlertBox()
	{
		driver.switchTo().alert().accept();
	}
	
	public void submit()
	{
		loginButton.click();

	}
}
