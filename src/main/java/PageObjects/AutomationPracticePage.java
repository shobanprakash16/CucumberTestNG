package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ultils.BaseClass;
import Ultils.BrowserUtils;

public class AutomationPracticePage extends BaseClass {
	
	private static By radiobutton1=By.xpath("(//input[@class='radioButton'])[1]");
	private static By radiobutton2=By.cssSelector("input[value='radio2']");
	private static By RadioButton3=By.cssSelector("input.radioButton[value='radio3']");
	
	private static By autoSuggestion=By.cssSelector("input#autocomplete");
	
	private static By dropDown =By.id("dropdown-class-example");
	
	private static By CheckBox1=By.cssSelector("input#checkBoxOption1");
	private static By CheckBox2=By.cssSelector("input[id='checkBoxOption2']");
	private static By CheckBox3=By.cssSelector("input#checkBoxOption3");
	
	private static By alertTextBox=By.name("enter-name");
	private static By alertBtn=By.id("alertbtn");
	private static By confirmBtn=By.id("confirmbtn");
	
	private static By courseTableId=By.xpath("//table[@class='table-display']");
	
	private static By newWindowBtn=By.id("openwindow");
	private static By newTabBtn=By.id("opentab");
	
	private static By hideBtn =By.id("hide-textbox");
	
	private static By newWindowCoursesBtn=By.xpath("//a[contains(text(),'our Courses')]");
	
	private static By mouseHoverBtn=By.xpath("//div[@class='mouse-hover']");
	private static By mouseHoverTopBtn=By.xpath("//div[@class='mouse-hover-content']/a[text()='Top']");
	private static By mouseHoverReloadBtn=By.xpath("//div[@class='mouse-hover-content']/a[text()='Reload']");
	
	private static By iframe=By.name("iframe-name");
	private static By iframeHomeBtn=By.xpath("(//a[normalize-space()='Home'])[1]");
	
	
	
	public static void testBrowserActions() throws InterruptedException {
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Get Page Title
		String title=BrowserUtils.getPageTitle();
		System.out.println("===Page Title Is:"+title+"===========");
		
		//Click radio Button
		BrowserUtils.clickElement(radiobutton1);		
		
		//Click Check Box
		BrowserUtils.clickElement(CheckBox1);
		BrowserUtils.clickElement(CheckBox2);
		BrowserUtils.clickElement(CheckBox3);

		
		//Send Text
		BrowserUtils.enterText(autoSuggestion, "India");
		
		
		//DropDown
		Select sel=new Select(driver.findElement(dropDown));
		sel.selectByValue("option2");
		
		//AutoSuggestion
		
		//Alert
		driver.findElement(alertTextBox).sendKeys("Shoban");
		
		//Click On alert Btn
		driver.findElement(alertBtn).click();
		System.out.println("========Alert Text======="+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//Accept Confirm Btn
		driver.findElement(confirmBtn).click();
		System.out.println("========Alert Text======="+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//Dismiss Confirm Btn
		driver.findElement(confirmBtn).click();
		System.out.println("========Alert Text======="+driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		//Table Functions
		WebElement table=driver.findElement(courseTableId);
		
		List<WebElement> rows =table.findElements(By.tagName("tr"));
		
		int RowCount=rows.size();
		System.out.println("Row Count is "+RowCount);
		
		/*
		 *  for(WebElement row:rows){
		 *  List<WebElement> cells =row.findElements(By.tagName("td")); 
		 *  	for(WebElement cell:cells) { 
		 *  System.out.println(cell.getText()+ "|"); 
		 *  } 
		 * }
		 */
		
		
		for(int i=1;i<RowCount;i++) {
			System.out.println("Row No is"+i);
			List<WebElement> cells =rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j< cells.size();j++) {				
				System.out.println(cells.get(j).getText()+ "|");
			}
		}
				
	
		
		
		//Window Handles
		
		driver.findElement(newWindowBtn).click();		
		wait.until(driver -> driver.getWindowHandles().size()>1);
		
		String mainWindow=driver.getWindowHandle();
		
		System.out.println("Main Window Name==="+mainWindow);
		
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i=allWindows.iterator();
		
		while(i.hasNext()) {
			String childWindow=i.next();
			System.out.println("Child Window Name==="+childWindow);
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement ele=null;						
				ele= wait.until(ExpectedConditions.visibilityOfElementLocated(newWindowCoursesBtn));	
				System.out.println("New Window text==="+ele.getText());
				driver.close();
			}
		}		
		driver.switchTo().window(mainWindow);
		driver.findElement(hideBtn).click();
		
		
		//New Tab Handling
		driver.findElement(newTabBtn).click();	
		Thread.sleep(5000);
		List<String> tabs= new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		System.out.println("New Tab Title==="+driver.getTitle());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		System.out.println("Main Tab Title==="+driver.getTitle());
		
		
		//Hidden Btn
		driver.findElement(hideBtn).click();		
		
		
		//Mouse Hover Actions		
		driver.findElement(mouseHoverBtn).click();
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(mouseHoverTopBtn)).click().build().perform();
		Thread.sleep(3000);	
		
		driver.findElement(mouseHoverBtn).click();
		ac.moveToElement(driver.findElement(mouseHoverReloadBtn)).click().build().perform();
		
		
		//Keyboard Actions
		ac.keyDown(driver.findElement(alertTextBox),Keys.SHIFT)
		.sendKeys("hello")
		.keyUp(driver.findElement(alertTextBox),Keys.SHIFT).build().perform();	
		
		//Frames
		int framesize=driver.findElements(iframe).size();		

		//Index
		driver.switchTo().frame(0);
		driver.findElement(iframeHomeBtn).click();
		driver.switchTo().defaultContent();
		driver.findElement(hideBtn).click();	
		
		//Name
		driver.switchTo().frame("iframe-name");
		driver.findElement(iframeHomeBtn).click();
		driver.switchTo().defaultContent();
		driver.findElement(hideBtn).click();	
		
		//WebElement
		driver.switchTo().frame(driver.findElement(iframe));
		driver.findElement(iframeHomeBtn).click();
		driver.switchTo().defaultContent();
		driver.findElement(hideBtn).click();	

		
		Thread.sleep(10000);
	}
	
	
	
	

			

}
