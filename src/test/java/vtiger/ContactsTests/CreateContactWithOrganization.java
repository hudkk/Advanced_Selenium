package vtiger.ContactsTests;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateContactWithOrganization extends BaseClass {
	
	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException{
	
		//read the data from the excel sheet test data
     String ORGNAME =  eUtil.readDataFromExcel("Contacts", 4,2)+jUtil.getRandomNumber();
     String LASTNAME= eUtil.readDataFromExcel("Contacts", 4, 3);
	 
	
         	//click on organization link
        	HomePage hp1=new HomePage(driver);
        	hp1.clickonOrganizationsLnk();
        	
        	 //click on create organization for look up image
        	OrganizationPage op=new OrganizationPage(driver);
        	op.clickoncreateorgimg();
        	
        	//create organization with mandtory details
        CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
        cnop.CreateOrganization(ORGNAME);
        	
      //validate for organization
        	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
        			String orgHeader=oip.getOrgheader();
        	Assert.assertTrue(orgHeader.contains(ORGNAME));
        	System.out.println(orgHeader+"---Organization created");
        	
        	//navigate to contacts link
           hp1.clickContactsLnk();
           
      //click on create contact look up image
           ContactsPage cp=new ContactsPage(driver);
           cp.clickcreateorglookupimg();
           
            //create contact with mandatory fields and save
           CreateNewContactPage cncp=new CreateNewContactPage(driver);
           cncp.CreateNewContact(driver,LASTNAME,ORGNAME);
            
            //validate for contacts
       	   ContactsInfoPage cip= new ContactsInfoPage(driver);
            String ContactHeader= cip.getContactHeader();
            Assert.assertTrue(ContactHeader.contains(LASTNAME));
            System.out.println(ContactHeader+"---Contact created");
    	   
    	    
    	    
   	}
   	

	 }