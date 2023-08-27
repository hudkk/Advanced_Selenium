package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTestScriptWithDDT {

	public static void main(String[] args) throws IOException {
	 
		//step 1:Read all the necessary data
		/*read data from the property file*/
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//create a object for properties
		Properties pobj=new Properties();
		
		
		//load fileinput stream
		pobj.load(fisp);
		
		//keys to read the value
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");//chrome,firefox.edge
		String USERNAME = pobj.getProperty("username");
	   String PASSWORD = pobj.getProperty("password");
	   
	   //step 2:read the data from Excel sheet Test data²
	   FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	 Workbook wb = WorkbookFactory.create(fise);
	String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	
	 WebDriver driver=null;//default initization value
	 
	//Srep 3:launch the browse runtime polymorphism
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();//automatically download the driver executables
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("Invalid Browser name");
	}
	     driver.get(URL);
        driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	    //step 4:Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
		//step 5:navigate to contacts link
	    driver.findElement(By.linkText("Contacts")).click();
	    
	    //step 6: click on create contact look up image
	    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    
	    //step 5:create contact with mandatory fields
	    driver.findElement(By.name("lastname")).sendKeys("LASTNAME");
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //step 6:verification for contact                                             
	   String ContactHeader= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(ContactHeader.contains("LASTNAME"))
	    {
	    System.out.println(ContactHeader+"---pass---");	
	    }
	    else
	    {
	    System.out.print("---fail---");
	    }
	    
	    //step 7:logout of application
	     WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     
	     //mouse hover
	     Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		//sign out
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successfull");
	}
	}


	

