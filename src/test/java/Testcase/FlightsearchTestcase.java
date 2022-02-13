package Testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;

import Background.Browserdriver;
import Commonmethods.commonsclass;
import Pages.Flightsearch;
import Pages.SearchlistPage;
import Utils.excelread;

public class FlightsearchTestcase extends Browserdriver
{
	


	commonsclass c= new commonsclass();
	excelread ER= new excelread();
	private final String  errorMessageinToField="From & To airports cannot be the same";
	int count=0;
	/*@Test(priority=0,dataProvider = "flightsearch" , dataProviderClass=dataproviderclass.class)
	public void validsearch(String fromlist,String Tolist,String date,String retundate)
	{
	System.out.println("Test case ");	
	}*/
	
	@Test(priority=0,dataProvider="Excelinput",dataProviderClass=dataproviderclass.class)
	public void validsearch(String from,String To,String depatdate,String returnDate)
	{
		String screenshotpath =null;
		
		try
		{
			Flightsearch FS= new Flightsearch(getdriver());
			System.out.println("the count is : "+count);
			if(count==0)
			{
			FS.loginpoup();
			FS.bottompopup();
			}
			FS.fromlist(from);
			test.log(LogStatus.INFO, "From Dropdown slected the value");
			FS.Tolist(To);
			test.log(LogStatus.INFO, "TO Dropdown slected the value");
			FS.depaturedate(depatdate);
			test.log(LogStatus.INFO, "Depature Date slected the value");
			FS.searchbutton();
			count=count+1;
			SearchlistPage SP= new SearchlistPage(getdriver());
			if(SP.PopularFilters()==true)
			{
			 screenshotpath=c.takescreenshot(getdriver());

			}
			
			getdriver().navigate().back();
			 
			test.log(LogStatus.PASS, test.addScreenCapture(screenshotpath));
		}
		catch(Exception s)
		{
			getdriver().navigate().back();
			test.log(LogStatus.FAIL, s);
			System.out.println(s);
		}
	}
	
	
	
	@Test(priority=1,dataProvider="Excelinput",dataProviderClass=dataproviderclass.class)
	public void invalidsearch(String from,String To,String depDate,String RetuDate)
	{

			String screenshotpath =null;
			
			try
			{
				Flightsearch FS= new Flightsearch(getdriver());
				System.out.println("the count is : "+count);
				if(count==0)
				{
				FS.loginpoup();
				FS.bottompopup();
				}
				FS.fromlist(from);
				test.log(LogStatus.INFO, "From Dropdown slected the value: "+from);
				FS.Tolist(To);
				test.log(LogStatus.INFO, "TO Dropdown slected the value: "+To);
				FS.fromlist(To);
				test.log(LogStatus.INFO, "From Dropdown slected the To value: "+To);
				Assert.assertEquals(FS.FromandTosameLocError(),errorMessageinToField);
				screenshotpath=c.takescreenshot(getdriver());
				count=count+1;
				test.log(LogStatus.PASS, test.addScreenCapture(screenshotpath));
			}
			catch(Exception s)
			{
				test.log(LogStatus.FAIL, s);
				System.out.println(s);
			}
		
	}
	


	
	
	
}
