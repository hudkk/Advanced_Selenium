package practise;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;

public class DemoTestScriptWithDDTAndGU {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//step 1: create object for all utilites
	     PropertyFileUtility pUtil=new PropertyFileUtility();
	    ExcelFileUtility eUtil=new ExcelFileUtility();
	     WebDriverUtility wUtil=new WebDriverUtility();
	    javaUtility jUtil=new javaUtility();
	
 //step 2:read all the necessary data
		/*read data from property file-common data*/
		String URL= pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//read the data from the excel sheet test data
    String ORGNAME =  eUtil.readDataFromExcel("Organizations", 1,2)+jUtil.getRandomNumber();
   	 WebDriver driver=null;//default initization value
   	 
   	//Srep 3:launch the browse runtime polymorphism
   	if(BROWSER.equalsIgnoreCase("chrome"))
   	{
   		WebDriverManager.chromedriver().setup();
   		driver=new ChromeDriver();
   	}
  
   	else if(BROWSER.equalsIgnoreCase("firefox"))
   	{
   	 	WebDriverManager.firefoxdriver().setup();
   	 	driver=new FirefoxDriver();
   	}
  
  	else
   	{
   		System.out.println("Invalid Browser name");
   	}
        	wUtil.maximiseWindow(driver);
         	wUtil.waitForPage(driver);
              	driver.get(URL);
              	
   	    //step 4:Login to application
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
   		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
   	    driver.findElement(By.id("submitButton")).click();
   	    
   		//step 4:click on organization link
     	 driver.findElement(By.linkText("Organizations")).click();
     	
     	 //step 5:click on create organization for look up image
     	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
     	
     	//step 6:create organization with mandtory details
     	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
     	
     	//step 7:save
     	driver.findElement(By.xpath("//input[@title='Save[Alt+S]']")).click();
   	 
     	//step 8:validate
     	String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
     	if(orgHeader.contains(ORGNAME))
     	{
     		System.out.println(orgHeader+"PASS");
     	}
     	else
     	{
     		System.out.println("FAIL");
     	}
     	
     	//step 9:Logout of app
         WebElement wb1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     	
         //mouse hover
	     Actions act=new Actions(driver);
		act.moveToElement(wb1).perform();
		//sign out
	driver.findElement(By.linkText("Sign Out")).click();
	}


}


	