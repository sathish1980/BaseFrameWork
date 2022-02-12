package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Background.Browserdriver;
import Commonmethods.commonsclass;

public class Flightsearch extends commonsclass
{
	@FindBy (xpath="//li[text()='OneWay']//span")
	WebElement oneway;
	@FindBy (xpath="//li[text()='Round Trip']//span")
	WebElement roudway;
	@FindBy (xpath="//li[text()='Multi City']//span")
	WebElement multiway;
	@FindBy (xpath="(//div[@class='fsw_inner']//child::input)[1]")
	WebElement fromfield;
	WebDriver driver;
	String list_var= "(//div[@class='fsw_inner']//child::div)[1]";
	
	
	public Flightsearch(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void oneway()
	{
		try
		{
		//WebElement oneway =driver.findElement(By.xpath("//li[text()='OneWay']//span"));
		radiobuttonaction(oneway,driver);
		Browserdriver.logger.debug("radiobutton clicked");
		}
		catch(Exception e)
		{
			Browserdriver.logger.error("radio button not clicked" +e);
		}
	}
	
	public void roundtripway()
	{
		//WebElement roudway = driver.findElement(By.xpath("//li[text()='Round Trip']//span"));
		radiobuttonaction(roudway,driver);
		Browserdriver.logger.debug("radiobutton clicked");
	}
	
	public void muticity()
	{
		//WebElement multiway =driver.findElement(By.xpath("//li[text()='Multi City']//span"));
		radiobuttonaction(multiway,driver);
		Browserdriver.logger.debug("radiobutton clicked");
	}
	
	public void fromlist(String comparetext)
	{
		System.out.println("******** From List ********* ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			waitelementtobeclickable(driver,By.xpath(list_var));
		
			List<WebElement> googlelement=driver.findElements(By.xpath("//div[@data-cy='googleLogin']"));
			int value=googlelement.size();
			//System.out.println(value);
			if(value>0)
			{
			driver.findElement(By.xpath("//li[@data-cy='account']")).click();
			}
		
			//WebElement fromfield=driver.findElement(By.xpath("(//div[@class='fsw_inner']//child::input)[1]"));
			fromfield.click();
			Browserdriver.logger.debug("from dropdown clicked");
			waitelementtobeclickable(driver,By.xpath("//ul[@role='listbox']//li[1]//div[2]"));
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[1]//div[2]")));
			List<WebElement> fromlist=driver.findElements(By.xpath("//ul[@role='listbox']//li"));
			int size=fromlist.size();
			for(int i=1;i<=size;i++)
			{
				WebElement eachvalue=driver.findElement(By.xpath("//ul[@role='listbox']//li["+i+"]//div[2]"));
				String eachtextvalue=eachvalue.getText();
				if(eachtextvalue.equalsIgnoreCase(comparetext))
				{
					waitelementtobeclickable(driver,By.xpath("//ul[@role='listbox']//li[\"+i+\"]//div[2]"));
					eachvalue.click();
					Browserdriver.logger.debug("from Value Selected: " + comparetext);
					break;
				}
			}
		
	}
	
	public void Tolist(String tlist)
	{
		System.out.println("******** To List ********* ");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			waitelementtobeclickable(driver,By.xpath("(//div[@class='fsw_inner']//child::div)[2]"));
			List<WebElement> fromlist=driver.findElements(By.xpath("//ul[@role='listbox']//li"));
			int size=fromlist.size();
			if(size==0)
			{
			WebElement tofield=driver.findElement(By.xpath("//label[@for='toCity']//parent::div"));
			tofield.click();
			Browserdriver.logger.debug("To dropdown clicked");
			}
			
			List<WebElement> closebutton =driver.findElements(By.xpath("//span[@class='langCardClose']"));
			int closebuttonsie=closebutton.size();
			if(closebuttonsie>0)
			{
				driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
				
			}
			//waitelementtobeclickable(driver,By.xpath("//ul[@role='listbox']//li[1]//div[2]"));
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']//li[1]//div[2]")));
			
			for(int i=1;i<=size;i++)
			{
				WebElement eachvalue=driver.findElement(By.xpath("//ul[@role='listbox']//li["+i+"]//div[2]"));
				String eachtextvalue=eachvalue.getText();
				
				if(eachtextvalue.equalsIgnoreCase(tlist))
				{
					System.out.println("To list value :" +eachtextvalue);
					waitelementtobeclickable(driver,By.xpath("//ul[@role='listbox']//li["+i+"]//div[2]"));
					jsscroolintoview(driver,eachvalue);
					eachvalue.click();
					Browserdriver.logger.debug("To Value clicked: " + tlist);
					Browserdriver.logger.info("To Value clicked - info");
					break;
				}
			}
		
	}
	
	public void depaturedate(String date)
	{
		int inputdate =dateseperatefromcalender(date);
		String elementidentified="not done";
		waitelementtobeclickable(driver,By.xpath("//label[@for='departure']//parent::div"));
		WebElement tofield=driver.findElement(By.xpath("//label[@for='departure']//parent::div"));
		tofield.click();
		List<WebElement> Totalweeks = driver.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']"));
			
		
		int totalweeks =Totalweeks.size();
				for(int i=1;i<=totalweeks;i++)
				{
					List<WebElement> Totaldays =driver.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']["+i+"]//child::div[contains(@class,'DayPicker-Day')]"));
					int Totaldaysize =Totaldays.size();
					for (int j=1;j<=Totaldaysize;j++)
					{
					String classattribute=	driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']["+i+"]//child::div[contains(@class,'DayPicker-Day')]["+j+"]")).getAttribute("class");
						if (classattribute.contains("disabled"))
						{
							
						}
						else
						{
							String actaultext=driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']["+i+"]//child::div[contains(@class,'DayPicker-Day')]["+j+"]//p")).getText();
							if(Integer.parseInt(actaultext)==inputdate)
							{
								driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']["+i+"]//child::div[contains(@class,'DayPicker-Day')]["+j+"]")).click();
								Browserdriver.logger.debug("Date Selected");
								Browserdriver.logger.error("Date Selected");
								Browserdriver.logger.fatal("Date Selected -fatal");
								Browserdriver.logger.warn("Date Selected -warning");
								elementidentified= "done";
								break;
							}
							
						}
					}
					if(elementidentified=="done")
					{
						break;
					}
							
				}
	}
	
	
	public void returndate(String date)
	{
		int inputdate =dateseperatefromcalender( date);
		String elementidentified = "not done";
		waitelementtobeclickable(driver,By.xpath("//label[@for='return']//parent::div"));
		WebElement tofield=driver.findElement(By.xpath("//label[@for='return']//parent::div"));
		tofield.click();
		List<WebElement> Totalweeks = driver.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']"));
			
		
		int totalweeks =Totalweeks.size();
				for(int i=1;i<totalweeks;i++)
				{
					List<WebElement> Totaldays =driver.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']["+i+"]//child::div[contains(@class,'DayPicker-Day')]"));
					int Totaldaysize =Totaldays.size();
					for (int j=1;j<Totaldaysize;j++)
					{
					String classattribute=	driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']["+i+"]//child::div[contains(@class,'DayPicker-Day')]["+j+"]")).getAttribute("class");
						if (classattribute.contains("disabled"))
						{
							
						}
						else
						{
							String actaultext=driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']["+i+"]//child::div[contains(@class,'DayPicker-Day')]["+j+"]//p")).getText();
							if(Integer.parseInt(actaultext)==inputdate)
							{
								driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]//child::div[@class='DayPicker-Week']["+i+"]//child::div[contains(@class,'DayPicker-Day')]["+j+"]")).click();
								
								elementidentified= "done";
								break;
							}
							
						}
					}
					if(elementidentified=="done")
					{
						break;
					}
							
				}
	}
	
	
	public void searchbutton()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//p[@data-cy='submit']//child::a")).click();
	}
	
	public void loginpoup()
	{
		waitelementtobeclickable(driver,By.xpath("//li[@data-cy='account']"));
		WebElement popup= driver.findElement(By.xpath("//li[@data-cy='account']"));
		popup.click();
	}
	
	public void bottompopup()
	{
		
		List<WebElement> btmpp=driver.findElements(By.xpath("//span[@class='langCardClose']"));
		if(btmpp.size()>0)
		{
			WebElement popupfind=driver.findElement(By.xpath("//span[@class='langCardClose']"));
			popupfind.click();
		}
	}
	
	public String  FromandTosameLocError()
	{
		waitelementtobevisible(driver,driver.findElement(By.xpath("//div[@id='errorMessage']")));
		WebElement ErrorMessage= driver.findElement(By.xpath("//div[@id='errorMessage']//span[2]"));
		return returnText(ErrorMessage);
		
	}

}
