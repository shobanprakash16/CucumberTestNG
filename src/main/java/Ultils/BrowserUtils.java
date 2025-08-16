package Ultils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils extends BaseClass {
	
	//public static WebDriver driver;
	
	public static void clickElement(By element) {
		findAndWaitforElementToBeVisible(element).click();
		
	}
	
	public static String getPageTitle() {
		
		String Pagetitle=driver.getTitle();	
		return Pagetitle;
			
		}
	
	public static void enterText(By userEmail, String text) {
	findAndWaitforElementToBeClickable(userEmail).clear();
	driver.findElement(userEmail).sendKeys(text);	
		
	}

	private static WebElement findAndWaitforElementToBeClickable(By element) {
		 
		WebElement ele=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));		
			ele= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return ele;		
		
	}
	
	private static WebElement findAndWaitforElementToBeVisible(By element) {
		 
		WebElement ele=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));		
			ele= wait.until(ExpectedConditions.visibilityOfElementLocated(element));	
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return ele;		
		
	}
	
	
	public static void validateText(By element, String expectedText) {
		
		String ActualText= findAndWaitforElementToBeVisible(element).getText();
		System.out.println("Actual text is ==="+ActualText);
	//Assert.assertEquals(ActualText, expectedText);		
	}

}
