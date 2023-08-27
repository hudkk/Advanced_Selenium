package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorglookupimg;
	
//initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getcreteOrgLookUpImg() {
		return createorglookupimg;
	}
	//Business Library
	/*
	 * this mrethod will perform click operation on cfeak look up image
	
	 */
	public void clickoncreateorgimg()
	{
		createorglookupimg.click();
	}
	

}
