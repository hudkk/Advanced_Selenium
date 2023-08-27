package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	//declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement ContactHeadertext;
		
		//initialization
		public ContactsInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);//test script
		}
		public WebElement getContactHeadertext() {
			return ContactHeadertext;
		}
		//Business Library
		/*
		 * this method will capture the text org header and return it to caller
		 */
		public String getOrgheader()
		{
			return ContactHeadertext.getText();
			
		}

	}

