package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ultils.BaseClass;
import Ultils.BrowserUtils;


public class HomePage extends BaseClass {
	
	
private static By productName= By.xpath("//b[text()='ZARA COAT 3']");
	
	public static void getPageTitle() throws InterruptedException {
		Thread.sleep(5000);
		String title=driver.getTitle();
		System.out.println("Page Ttle is "+title);
		
	}
	
	public static void verifyProductname() {
		
		BrowserUtils.validateText(productName,"ZARA COAT 3");
		
	}

}
