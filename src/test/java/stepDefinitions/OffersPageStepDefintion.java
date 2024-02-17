package stepDefinitions;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetup;

public class OffersPageStepDefintion {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductname;
	TextContextSetup textContextSetup;
	PageObjectManager pageObjectManager;
	
	
	public OffersPageStepDefintion(TextContextSetup textContextSetup)
	{
		this.textContextSetup=textContextSetup;
	}
	
	
	@Then("^user searched for the (.+) shortname in offers page$")
	public void user_searched_for_the_shortname_in_offers_page(String shortName) throws InterruptedException {
	   
		switchToOffersPage();
		
	//	OffersPage offersPage=new OffersPage(textContextSetup.testBase.driver);
		OffersPage offersPage=textContextSetup.pageObjectManager.offersPage();
		
		offersPage.searchItem(shortName);
		
		offerPageProductname=offersPage.getProductName();
		//offerPageProductname = textContextSetup.driver.findElement(By.xpath("//td[text()='Tomato']")).getText();
		
		
		System.out.println(offerPageProductname);	
		
	}
	
	
	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		
		Assert.assertEquals(offerPageProductname, textContextSetup.landingPageProductName);  
		//Assert.assertEquals(offerPageProductname, landingPageProductName);    //assertEquals(expected, actual)
	}
	
	public void switchToOffersPage()
	{
		LandingPage landingPage=textContextSetup.pageObjectManager.getLandingPage();
		
		landingPage.selectTopDealsPage();
   
		textContextSetup.genericUtils.switchWindowToChild(); //calling through object reference
		
	}


}
