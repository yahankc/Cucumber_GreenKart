package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver webDriverManager() throws IOException // WebDriverManager is responsible to give the driver object
															// initialization
	{
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "//src//test//resources//global.properties"); // user.dir will get the path till
																					  // cucumberFramework(as other people will have different paths)
		Properties pro = new Properties();
		pro.load(fis);

		String url = pro.getProperty("QAUrl");
		if (driver == null) // webdriver will need not to create everytime it gets called. So it's if
							// already initialized then simply return the driver
							// Now wedriver will only initialize once for every scenario.
		{
			if (pro.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver(); // driver gets the life
			} else if (pro.getProperty("browser").equalsIgnoreCase("firefox")) {
				// firefox code
			}

			driver.get(url);
		}
		return driver;
	}
}
