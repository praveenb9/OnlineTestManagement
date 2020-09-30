package comcapg.otms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capg.otms.baseclass.Library;

public class OTMSQuestionPage extends Library{
	public OTMSQuestionPage(WebDriver driver) {

		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")
	WebElement questionLink;
	
	@FindBy(xpath = "/html/body/app-root/div/div/main/app-question/div/nav/ul/li[1]/a")
	WebElement questionAdd;
	
	@FindBy(xpath = "/html/body/app-root/div/div/main/app-question-add/div/a")
	WebElement questionAddBack;
	
	@FindBy(xpath = "/html/body/app-root/div/div/main/app-question/div/nav/ul/li[2]/a")
	WebElement questionList;
	
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/div/li/a")
	WebElement questionListBack;
	
	public void OpenQuestionOperations()
	{
		questionLink.click();
	}
	
	public void questionAdd()
	{
		questionAdd.click();
	}
	
	public void addQuestionBack()
	{
		questionAddBack.click();
	}
	
	public void OpenQuestionList()
	{
		questionList.click();
	}
	
	public void questionListBack()
	{
		questionListBack.click();
	}
}
