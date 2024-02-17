package utils;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

//All reusable codes (Eg. Explicit waits)
public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)	
	{
		this.driver=driver;
	}
	
	public void switchWindowToChild()  //whoever wants to use this method, will create an object of GenericUtils and sent driver as an argument
	{
		Set<String> s1 = driver.getWindowHandles();

		Iterator<String> itr = s1.iterator();

		String parentWindow = itr.next();
		String childWindow = itr.next();

		driver.switchTo().window(childWindow);
	}
	
	public void closeCurrentWindow()
	{
		driver.close();
		System.out.println("Current Page is closed");
	}
	
	public void closeAllWindows()
	{
		driver.quit();
		System.out.println("All Pages are closed");
	}
	
	
	
}
