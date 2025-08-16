package StepDefs;


import PageObjects.HomePage;
import io.cucumber.java.en.Then;

public class HomePageStepDef{
	
	@Then("I should Land on the Homepage")
	public void i_should_land_on_the_homepage() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		
		
		HomePage.getPageTitle();
		HomePage.verifyProductname();
	}
	  
	
	
}
