package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	 public PropertyFileUtility pUtil=new PropertyFileUtility();
	 public ExcelFileUtility eUtil=new ExcelFileUtility();
	 public WebDriverUtility wUtil=new WebDriverUtility();
	public javaUtility jUtil=new javaUtility();

	public WebDriver driver;
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("------Datebase Connnection successful----");
	}
	@BeforeClass
	public void bcConfig() throws IOException 
	{
		String URL= pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
	
	//Step 2:launch the browse runtime polymorphism
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("system.out.println(\"----\"+BROWSER+\" Launched successfully----\");");
	}
else if(BROWSER.equalsIgnoreCase("firefox"))
	{
	 	WebDriverManager.firefoxdriver().setup();
	 	driver=new FirefoxDriver();
		System.out.println("system.out.println(\"----\"+BROWSER+\" Launched successfully----\");");
	}
else
	{
		System.out.println("Invalid Browser name");
	}
   	         wUtil.maximiseWindow(driver);
    	     wUtil.waitForPage(driver);
            	driver.get(URL);
	}
            	
	@BeforeMethod
	public void bmConfig()
		{
		String URL= pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		//step 4:Login to application
        LoginPage hp=new LoginPage(driver);
      	hp.loginToApp(USERNAME,PASSWORD);
      	System.out.println(" login succesfull----");
    	
		
		
		}
	@AfterMethod
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutofApp(driver);
		System.out.println("----logout succesful---");
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("---- Browser closed succesfully---");
	}
	@AfterSuite
	
		public void asConfig()
		{
		System.out.println("------Datebase Connnection successful----");
		}
		
}