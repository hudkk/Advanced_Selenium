package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to webdriver actions
 * @author Vijayalakshmi S
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will wait for the page load
	 * @param driver
	 */
	public void waitForPage(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait untill element becomes visible
	 * @param driver
	 * @param element
	 */

	
	public void waitForElementToBeVisible(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait untill the element becomes clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	/**
	 * this method will handle the drop down based on index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method will handle the drop down based on value /method overloading
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value)
	{
		Select sel=new Select(element);
				sel.selectByValue(value);
	}

	/**
	 * this method will handle dropdown based on visibletext
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element)//argument shouls be different or the order of the argument should be different
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * this method will perform mouseover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void RightclickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void rightclickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void doubleclickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	public void doubleclickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void dragandDropAction(WebDriver driver,WebElement srcElement, WebElement dstElement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement,dstElement).perform();
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this methos will capture the text from alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void handleFrame(WebDriver driver,String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchtoParent(WebDriver driver) 
	{
		driver.switchTo().parentFrame();
	}
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method will switch the window based on partial window title
	 * @param driver
	 * @param partialwintitle
	 */
	public void switchTowindow(WebDriver driver,String partialwintitle)
	{
		//step 1: capture all the window IDs
		Set<String> winIDs = driver.getWindowHandles();
		
		//step 2:navigate to each window and campare the title
		for(String win:winIDs)
		{
			//step 3:switch to window and capture the title
			String wintitle = driver.switchTo().window(win).getTitle();
			
			//step 4:compare the title with required partial title
			if(wintitle.contains(partialwintitle))
			{
				break;
			}
		}
		}
	/**
	 * this method take sc and save it in required folder
	 * @param driver
	 * @param Screenshot
	 * @return
	 * @throws IOException
	 */
		public String takeScreenShot(WebDriver driver ,String Screenshot) throws IOException
		{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		 
		//inside the folder sc will be saved
		File dst=new File(".\\ScreenShots\\"+Screenshot+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();//returns the absolute pathname of the given file object,used for extent reports
		}
		/**
		 * this methos will perform random scroll downwards vertically
		 * @param driver
		 */
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver ;
			js.executeScript("window.scrollBy(0,500)","");
		}
		/**
		 * this methos will scroll untill the element is identified in DOM(document object model)
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			int y=element.getLocation().getY();//elements in y co-ordinate vertical axis
			js.executeScript("window.scrollBY(0,"+y+")",element);//it works on point by point
		}
}
		
		
		

