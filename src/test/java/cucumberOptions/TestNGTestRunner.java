package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
glue="stepDefinitions",
//tags= "@PlaceOrder",
//tags="@searchItems",
tags="@PlaceOrder or @searchItems",
plugin= {"html:target/cucumber.html","json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //Reporting purpose
"rerun:target/failed_scenarios.txt"}, 
monochrome=true)

public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	
	@Override
	@DataProvider(parallel = true)
	public Object [][] scenarios()
	{
		return super.scenarios();
	}

}
