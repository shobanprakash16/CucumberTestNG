package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ultils.BaseClass;
import Ultils.BrowserUtils;

public class LoginPage extends BaseClass {
	
	private static By userEmail= By.id("userEmail");
	private static By passwordEle= By.id("userPassword");
	private static By loginBtn= By.id("login");
	private static By cartBtn= By.xpath("//button[@routerlink='/dashboard/cart']");
	private static By LogOutBtn= By.xpath("//button[normalize-space()='Sign Out']");	
	
	
	public static void LoginApplication() {		
		
		BrowserUtils.enterText(userEmail,"shobanpractise@gmail.com");
		BrowserUtils.enterText(passwordEle,"Password@123");
		BrowserUtils.clickElement(loginBtn);	
	}
	
	public static void LogOutApplication() throws InterruptedException {
		System.out.println("Inside Log out Function=====");
	//	Thread.sleep(3000);
		BrowserUtils.clickElement(cartBtn);	
		Thread.sleep(3000);
		BrowserUtils.clickElement(LogOutBtn);	
		System.out.println("Clicked Log out Button=====");
	}

}
