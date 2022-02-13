package Background;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.github.dockerjava.api.model.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.Propertyclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserdriver 
{

	//public WebDriver driver ;
	public  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ExtentReports report;
	public static ExtentTest test;
	static String reportpath= System.getProperty("user.dir")+"\\Reports\\";
	public static Logger logger = LogManager.getLogger("class");  
	public String Browser_Name = null;
	public String Browser_Version = null ;
	
	public void setdriver(WebDriver driver)
	{
		this.driver.set(driver);
	}
	
	public WebDriver getdriver()
	{
		return this.driver.get();
	}
	

	public static void extreport()
	{
		report = new ExtentReports(reportpath+"extenreport.html",true);
		test= report.startTest("Automation report");
		
	}
	
	public static void reportclose()
	{
		//test.close();
		report.flush();
		
	}
	
	public void browserselection(String browser)
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//test//java//log4j.properties");
		//String browser=Propertyclass.propreaddata().getProperty("brower");
		if(browser.equalsIgnoreCase("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		logger.info("before launch");
		WebDriverManager.chromedriver().setup();
		logger.info("after launch");
		setdriver( new ChromeDriver());
		
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		

		 //driver= new ChromeDriver(c);
		 maximize();
		logger.debug("browser intialize");
		logger.info("info log");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			//System.setProperty("webdriver.edge.driver", 
				//	"D:\\Software\\edgedriver_win64\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			//driver= new EdgeDriver();
			setdriver( new EdgeDriver());
			//maximize();
		
		}
	}
	
	public String urldata()
	{
		String urlvlue=Propertyclass.propreaddata().getProperty("URL");
		return urlvlue;
	}
	
	public void maximize()
	{
		getdriver().manage().window().maximize();
	}
	
	@Parameters("browser")
	@BeforeTest
	public void launchurl(String browser)
	{
		//String browser=Propertyclass.propreaddata().getProperty("browser");
		browserselection(browser);
		getdriver().get(urldata());
		
	}
	
	
	@AfterTest
	public void tear()
	{
		getdriver().quit();	
	}
	
	@BeforeSuite
	public void launch()
	{
		extreport();
	}
	
	@AfterSuite
	public void teardonw()
	{
		reportclose();
		
	}
}
