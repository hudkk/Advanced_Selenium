package vtiger.OrganizationTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganization extends BaseClass{

	public static void main(String[] args) throws IOException, InterruptedException {
	
	   String ORGNAME= eUtil.readDataFromExcel("Organizations",1,2);
	  
      WebDriver driver=null;//default initization value
   	 
        //click on Organizations link
	   HomePage hp= new HomePage(driver);
	   hp.clickonOrganizationsLnk();
   	  
   		//click on create organization look up image
	   OrganizationPage op=new OrganizationPage(driver);
	   op.clickoncreateorgimg();
   		
   		//create organization with mandtory details
     CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
     cnop.CreateOrganization(ORGNAME);
     
     //validate
     OrganizationInfoPage oip=new OrganizationInfoPage(driver);
     String OrgHeader=oip.getOrgheader();
     Assert.assertTrue(OrgHeader.contains(ORGNAME));
   
     	
     	
		
	}

}



	