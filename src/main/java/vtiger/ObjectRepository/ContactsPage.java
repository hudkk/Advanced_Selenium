package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontactlookupimg;

	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization

	public WebElement getCreateorglookupimg() {
		return createcontactlookupimg;
	}
	
	//Business Libraries
	/*
	 * 
	 */
	public void clickcreateorglookupimg()
	{
	createcontactlookupimg.click();
	}
}
