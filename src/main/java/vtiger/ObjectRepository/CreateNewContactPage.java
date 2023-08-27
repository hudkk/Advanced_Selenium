package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath=" //input[@name='account_name']/following-sibling::img[@title='Select']")
       private WebElement OrgLookUpImage;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
    @FindBy(name="search")
    private WebElement searchbtn;
    
    //initization
    public CreateNewContactPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookUpImage() {
		return OrgLookUpImage;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	//Business library
	/**
	 * this method will create new contact with lastname
	 * @param LastName
	 */
    
	public void CreateNewContact(String LastName)
	{
		LastNameEdt.sendKeys(LastName);
		SaveBtn.click();
	}
	/**
	 * 
	 */
	public void CreateNewContact( WebDriver driver,String LastName, String OrgName)
	{
		LastNameEdt.sendKeys(LastName);
		OrgLookUpImage.click();
		switchTowindow(driver,"Accounts");
		searchEdt.sendKeys(OrgName);
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchTowindow(driver,"Contacts");
		SaveBtn.click();
	}
}
