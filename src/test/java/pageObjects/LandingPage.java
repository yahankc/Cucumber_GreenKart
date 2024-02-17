package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class LandingPage {
	
	WebDriver driver;		//global variable
	
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;					//To use "WebDriver driver" in the whole class,  we create one global object and assign it a driver											
	}
	
	By search =By.xpath("//input[@type='search']");
	By productName= By.xpath("//h4[@class='product-name']");
	By topDeals=By.xpath("//a[text()='Top Deals'] ");
	
	By incrementButton =By.xpath("//a[@class='increment']");
	By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	By cartButton = By.xpath("//a[@class='cart-icon']/*[@alt='Cart']");
	
	By proceedToCheckout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
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
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	
	
	public void incrementItems(int quantity)
	{
		int i=quantity-1;
		while(i>0)
		{
			driver.findElement(incrementButton).click();
			i--;
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addToCartButton).click();
	}
	
	public void checkOutItems()
	{	
		driver.findElement(cartButton).click();
		driver.findElement(proceedToCheckout).click();
	}
}
