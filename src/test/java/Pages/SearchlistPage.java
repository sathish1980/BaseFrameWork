package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commonmethods.commonsclass;

public class SearchlistPage extends commonsclass
{
	String elementchekbox="//span[text()='Refundable Fares']//preceding::span[@class='customCheckbox']";

	WebDriver driver;
	public SearchlistPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public Boolean PopularFilters()
	{
		waitelementtobeclickable(driver,By.xpath(elementchekbox));
		WebElement RefundableRate=driver.findElement(By.xpath("elementchekbox"));
		return RefundableRate.isDisplayed();
	}
	
	
}
