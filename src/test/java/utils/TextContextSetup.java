package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
//we are relying on this class TextContextSetup to avoid creating objects in the stepdefinition.
//so we are creating objects here and injecting this class directly in the stepdefinition
//so all the objects you've created here, you'll have the access in your stepdefinition file also
// because of the textcontextSetup dependency injection in the constructor of your stepdefinition file.

public class TextContextSetup {
	
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	
	public TextContextSetup() throws IOException
	{
		testBase=new TestBase();
		pageObjectManager =new PageObjectManager(testBase.webDriverManager());
		genericUtils= new GenericUtils(testBase.webDriverManager());
		
		
		//webDriverManager() will give you the actual driver which comes from the testbase class
		
		//pageObjectManager takes the driver from webdrivermanager and deligate it to all the page object files
		
		// and that driver is initialized at TextContextSetup class
	}
	
	
	

}
