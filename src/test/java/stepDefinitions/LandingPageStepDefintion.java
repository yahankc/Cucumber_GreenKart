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
import utils.TextContextSetup;

public class LandingPageStepDefintion {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductname;
	public TextContextSetup textContextSetup;
	public LandingPage landingPage;
	
	public LandingPageStepDefintion(TextContextSetup textContextSetup)
	{
		this.textContextSetup=textContextSetup;
		landingPage= textContextSetup.pageObjectManager.getLandingPage(); // defined it in the constructor, so do not have to specify it again and again in the class
	}
	
	@Given("user is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		
	//	textContextSetup.testbase.webDriverManager();	
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	
	@When("^user searched with shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		
		//LandingPage landingPage= new LandingPage(textContextSetup.driver);  // it's alternative is below
		//LandingPage landingPage= textContextSetup.pageObjectManager.getLandingPage(); // no need to define here for calling landingPage object (as we've already define it in the constructor)
		
		landingPage.searchItem(shortName);
	    Thread.sleep(2000);
	    textContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
	    System.out.println(textContextSetup.landingPageProductName);
	    
//	    landingPageProductName=landingPage.getProductName().split("-")[0].trim();
//	    System.out.println(landingPageProductName);
	}
	
	}
	
