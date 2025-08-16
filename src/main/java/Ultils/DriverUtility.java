package Ultils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtility {
	
	//public static WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getBrowserDriver(String browserName) {
		
		if (browserName.contentEquals("chrome")) {
			System.out.println("/inside chrome setup");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		//	driver=new ChromeDriver();
			System.out.println("/done chrome setup");

		} else if (browserName.contentEquals("edge")) {
			System.out.println("/inside Edge setup");
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			//driver=new EdgeDriver();
			System.out.println("/done edge setup");
		} else {
			System.out.println("Please provide the proper Browser Name");
		}
		
		
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
