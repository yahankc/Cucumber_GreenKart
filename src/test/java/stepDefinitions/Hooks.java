package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TextContextSetup;

public class Hooks {
	
	TextContextSetup textContextSetup;
	
	public Hooks(TextContextSetup textContextSetup)
	{
		this.textContextSetup= textContextSetup;
	}
	
	@After
	public void AfterScenario() throws IOException
	{
		textContextSetup.testBase.webDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException //Scenario is a class which has the knowledge of all the scenarios in our framework
	{
		WebDriver driver=textContextSetup.testBase.webDriverManager();
		if(scenario.isFailed()) 
		{
			//screenshot
			File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image"); //Attcahing ss to the scenario, which will be picked by Extent report
		}
	}


}
