package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	  
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By productName= By.xpath("//table[@id='productCartTables']/tbody//td/p");
	By applyButton= By.xpath("//button[text()='Apply']");
	By placeOrderButton= By.xpath("//button[text()='Place Order']");
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public boolean verifyApplyButton()
	{
		return driver.findElement(applyButton).isDisplayed();
	}
	
	public boolean verifyPlaceOrderButton()
	{
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
	

}
