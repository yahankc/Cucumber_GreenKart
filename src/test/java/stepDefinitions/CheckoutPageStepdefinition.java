package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class CheckoutPageStepdefinition {
	
	public TextContextSetup textContextSetup;
	public LandingPage landingPage;
	public CheckoutPage checkoutPage;
	String checkoutPageProductName;
	
	public CheckoutPageStepdefinition(TextContextSetup textContextSetup)
	{
		this.textContextSetup=textContextSetup;
		landingPage=textContextSetup.pageObjectManager.getLandingPage();
		checkoutPage=textContextSetup.pageObjectManager.getCheckoutPage();
	}
		
	
//	  @When("user searched {string} product in the landing page") 
//	  public void user_searched_product_in_the_landing_page(String string) throws InterruptedException {
//	    
//	  landingPage.searchItem(string);	  
//	  Thread.sleep(2000);	  
//	  textContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();	  
//	  System.out.println("LandingPage Product Name: "+textContextSetup.landingPageProductName);
//	  
//	  }
//	  
//	  @When("user checkout multiple items of product in landing page and Add to cart them"
//	  ) 
//	  public void user_checkout_multiple_items_of_product_in_landing_page_and_add_to_cart_them() {
//	  
//	  landingPage.incrementItems(); 
//	  landingPage.incrementItems();
//	  landingPage.incrementItems();	  
//	  landingPage.addToCart();
//	  
//	  }
//	  
//	  @Then("validate product name in checkout page matches with landing page")
//	  public void validate_product_name_in_checkout_page_matches_with_landing_page() throws
//	  InterruptedException {
//		 
//	  landingPage.proceedToCheckout();	  
//	  Thread.sleep(2000);    
//	  checkoutPageProductName=checkoutPage.getProductName().split("-")[0].trim();  
//	  System.out.println("checkoutPage ProductName: "+checkoutPageProductName);	  
//	  Assert.assertEquals(textContextSetup.landingPageProductName,checkoutPageProductName);
//	  
//	  }
//	  
//	  @Then("validate the presence of Apply and Place order button") 
//	  public void validate_the_presence_of_apply_and_place_order_button() {
//	  
//	  Assert.assertTrue(checkoutPage.applyButton());
//	  Assert.assertTrue(checkoutPage.placeOrderButton());
//	  
//	  }
	
	  
	@When("^added (\\d+) items of the selected product to cart$")
	public void added_items_of_the_selected_product_to_cart(int quantity)
	{
		landingPage.incrementItems(quantity);
		landingPage.addToCart();
	}
	
	@Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_in_checkoutpage(String name) throws InterruptedException
	{
		landingPage.checkOutItems();
		Thread.sleep(4000);
		//Assertion to extract name from screen and compare with name
		
	}
	
	@Then("^verify user has ability to enter promo code and place the order$")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{	
		Assert.assertTrue(checkoutPage.verifyApplyButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
	}
	
	 
}
