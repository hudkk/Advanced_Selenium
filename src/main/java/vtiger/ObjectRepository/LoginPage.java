package vtiger.ObjectRepository;
/**
 * @author Vijayalakshmi S
 */

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  
	//rule 1: create a pom class for every web page

	//rule 2:identify the webelements with @findBy,@findall,@findBys
	
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;
	
	//rule 3: create a constructor to initialize these web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//rule 4:provide getters to access the elements

	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	/**
	 * This method will login to app with usn and pwd
	 * @param Username
	 * @param Password
	 */
	//Business Libraries -generic methods specific to current project
	public void loginToApp(String Username,String Password)
	{
		UsernameEdt.sendKeys(null);
		PasswordEdt.sendKeys(Password);
		SubmitBtn.click();
	}
	
}
