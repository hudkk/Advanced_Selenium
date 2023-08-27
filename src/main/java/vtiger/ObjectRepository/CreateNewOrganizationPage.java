package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{

	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
   private WebElement IndustryDropdown;
	
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
  private WebElement SaveBtn;
  
    //initializations
public CreateNewOrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getOrgNameEdt() 
{
	return OrgNameEdt;
}
public WebElement getIndustryDropdown() 
{
	return IndustryDropdown;
}
public WebElement getSaveBtn() 
{
	return SaveBtn;
}
//business libraries
/**
 * this method will create organization with orgname
 * @param OrgName
 */
public void CreateOrganization(String OrgName)
{
	OrgNameEdt.sendKeys(OrgName);
	SaveBtn.click();
}
public void createOrganization(String OrgName,String industryType)
{
	OrgNameEdt.sendKeys(OrgName);
	handleDropdown(IndustryDropdown, industryType);
	SaveBtn.click();
}
}

