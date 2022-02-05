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
import Utils.excelread;

public class FlightsearchTestcase extends Browserdriver
{
	


	
	@Test(priority=0,dataProvider = "flightsearch" , dataProviderClass=dataproviderclass.class)
	public void validsearch(String fromlist,String Tolist,String date,String retundate)
	{
	System.out.println("Test case ");	
	}
	
	
	
}
