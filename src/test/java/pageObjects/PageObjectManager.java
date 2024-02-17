package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;  //initializing object globally
	public OffersPage offersPage;
	public WebDriver driver;
	public CheckoutPage checkoutPage;
	
	
	public PageObjectManager(WebDriver driver) // this driver will come from the class where you are calling this PageObjectManager.
	{
		this.driver= driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage(driver); 
		return landingPage;
	}

	public OffersPage offersPage()
	{
		offersPage= new OffersPage(driver);
		return offersPage;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		checkoutPage= new CheckoutPage(driver);
		return checkoutPage;
	}
}
