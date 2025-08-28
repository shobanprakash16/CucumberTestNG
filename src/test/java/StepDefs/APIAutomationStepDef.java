package StepDefs;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIAutomationStepDef {

	
	@Given("This step is to test API")
	public void This_step_is_to_test_API() throws InterruptedException {
		
		System.out.println("Inside API Automation Step Definition");
		//Test the API's
		/*
		 * String URL= "https://automationexercise.com/api/productsList";
		 * RestAssured.baseURI=URL;
		 * 
		 * RequestSpecification req=RestAssured.given().log().all();
		 * //req.header("Content-Type","JSON"); Response res=req.get(URL);
		 * 
		 * String response=res.body().jsonPath().prettify();
		 * System.out.println("Response is==="+"Status code==="+response);
		 */
		
	}

}
