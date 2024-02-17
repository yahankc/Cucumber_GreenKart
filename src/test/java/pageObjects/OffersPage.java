package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	public WebDriver driver;		//global variable
	
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;					//To use "WebDriver drive" in the whole class,  we create one global object and assign it a driver
											
	}
	
	By search =By.xpath("//input[@type='search']");
	By productName= By.xpath("//table[@class='table table-bordered']//td[1]");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}
