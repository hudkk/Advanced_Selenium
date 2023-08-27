package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	//declaration
	//identify the webelements with @findBy
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk11;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk1;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	//initilazation
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrganizationsLnk11() {
		return OrganizationsLnk11;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk1() {
		return OpportunitiesLnk1;
	}

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk11;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Libraries
	/*
	 * this method will perform click operation on organization link
	 */
	public void clickonOrganizationsLnk()
	{
		OrganizationsLnk11.click();
	}
	/*
	 * this method will perform click operation on contacts lnk
	 */
	public void clickContactsLnk()
	{
		ContactsLnk.click();
	}
	/*
	 * this method will perform logout operation
	 */
	public void logoutofApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
	}

	
	
    

