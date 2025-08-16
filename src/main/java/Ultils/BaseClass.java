package Ultils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass{

	public static WebDriver driver;
	
public void initializeDriver() {
		
	System.out.println("Inside Driver Initialization");
		Properties prop= PropertiesUtil.loadConfigProperties();		
		String browserName= prop.get("browser").toString();	
		String url=prop.getProperty("url").toString();		
		System.out.println("Browser Name is   " + browserName);			
	    driver= DriverUtility.getBrowserDriver(browserName);	
	    System.out.println("URL is ==="+url);
		driver.get(url);
		System.out.println("URL is Launched===");
		driver.manage().window().maximize();		
		
	}

public void closeDriver() {
	
	System.out.println("Inside Close Driver");
	driver.quit();	
	
}


}
