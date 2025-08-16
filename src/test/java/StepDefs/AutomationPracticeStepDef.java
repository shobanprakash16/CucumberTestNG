package StepDefs;

import PageObjects.AutomationPracticePage;
import PageObjects.LoginPage;
import Ultils.BaseClass;
import Ultils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AutomationPracticeStepDef extends BaseClass {
		

	@Given("I get the Title Of the Page")
	public void I_get_the_Title_Of_the_Page() throws InterruptedException {
		
		System.out.println("Inside Step Definition");
		//Test the Browser actions
		AutomationPracticePage.testBrowserActions();		
		
	}




}
