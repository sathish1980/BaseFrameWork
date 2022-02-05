package Testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.excelread;

public class dataproviderclass 
{

	@DataProvider(name = "flightsearch")
	public Object[][] exceldata() throws IOException
	{
		return excelread.read();
	}
	
	@DataProvider(name ="return")
	public Object[][] returndata() throws IOException
	{
		return excelread.read();
	}
	
}
