package Commonmethods;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonsclass 
{
	private WebDriverWait wait;

	public void clickaction(WebElement clickelement , WebDriver driver)
	{
		try
		{
		if(clickelement.isDisplayed()==true)
		{
			wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(clickelement));
			clickelement.click();
		}
		}
		catch(Exception e)
		{
			System.out.println("The corresponding element is not clickable:"+e);
		}
	}
	
	public void radiobuttonaction(WebElement clickelement , WebDriver driver)
	{
		try
		{
		if(clickelement.isSelected()==false)
		{
			wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(clickelement));
			clickelement.click();
		}
		}
		catch(Exception e)
		{
			System.out.println("The corresponding element is not clickable:"+e);
		}
	}
	
	public void checkboxbuttonaction(WebElement clickelement , WebDriver driver)
	{
		try
		{
		if(clickelement.isSelected()==false)
		{
			wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(clickelement));
			clickelement.click();
		}
		}
		catch(Exception e)
		{
			System.out.println("The corresponding element is not clickable:"+e);
		}
	}
	
	public void textenter(WebElement clickelement, String texttobeenter)
	{
		try
		{
		if(clickelement.isDisplayed()==true)
		{
		clickelement.clear();
		clickelement.sendKeys(texttobeenter);
		}
		}
		catch(Exception e)
		{
			System.out.println("The corresponding element is not clickable:"+e);
		}
	}
	
	public void waitelementtobeclickable(WebDriver driver,By value) 
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(value));
		
	}
	
	
	public void waitelementtobevisible(WebDriver driver,WebElement value) 
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfAllElements(value));
		
	}
	
	public void jsscroolintoview(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		// now execute query which actually will scroll until that element is not appeared on page.
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	
	public void calenderacces(WebDriver driver,List<WebElement> Date)
	{
		
	}
	
	public int dateseperatefromcalender(String date)
	{
		String[] datevalue =date.split("/");
		return Integer.parseInt(datevalue[1]);
		
	}
	
	public String monthseperatefromcalender(String date)
	{
		String[] monthvalue =date.split("/");
		return monthvalue[0];
		
	}
	
	public String yearseperatefromcalender(String date)
	{
		String[] monthvalue =date.split("/");
		return monthvalue[2];
		
	}
	
	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
	      //This method returns the time in millis
	    long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//Screenshot//Testcase_1_"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Destinationfile.toString();
	}
	
	public String returnText(WebElement textobeReturn)
	{
		return textobeReturn.getText();
	}
}
