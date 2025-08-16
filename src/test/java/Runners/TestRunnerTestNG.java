package Runners;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
			features= {"src/test/java/features"},
			glue= {"StepDefs"},
			plugin = {
					"pretty",
					"html:target/cucucmber.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
					"timeline:test-output-thread/"
					},
			tags="@APIAutomation",
			dryRun=false
			
			)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{
	@DataProvider(parallel=false)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
		
	}

}
