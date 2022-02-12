package Testcase;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Background.Browserdriver;

public class SearchListTestcase extends Browserdriver
{
	@Test(priority=2)
	public void validsearchList()
	{
		try
		{
			System.out.println("valid Test case in search list ");	
			test.log(LogStatus.PASS, "Sucesfully exected this test case");
		}
		catch(Exception s)
		{
			test.log(LogStatus.FAIL, "This test case is not executed");
			System.out.println(s);
		}

	}
	
}
