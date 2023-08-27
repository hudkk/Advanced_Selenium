package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeadertext;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);//test script
	}
	public WebElement getOrgHeadertext() {
		return OrgHeadertext;
	}
	//Business Library
	/*
	 * this method will capture the text org header and return it to caller
	 */
	public String getOrgheader()
	{
		return OrgHeadertext.getText();
		
	}

}
