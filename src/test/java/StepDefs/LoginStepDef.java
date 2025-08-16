package StepDefs;

import PageObjects.LoginPage;
import Ultils.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDef extends BaseClass {
		

	@Given("I Login to Application")
	public void i_login_to_application1() {
	    // Write code here that turns the phrase above into concrete actions
		
		LoginPage.LoginApplication();
	}

	@Then("I logout of the application")
	public void i_logout_of_the_application() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage.LogOutApplication();
	   
	}




}
