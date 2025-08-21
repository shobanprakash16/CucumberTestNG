package StepDefs;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Ultils.BaseClass;
import Ultils.PropertiesUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	Properties prop = PropertiesUtil.loadConfigProperties();
	String testType = prop.get("TestType").toString();

	@Before
	public void setup() {

		
		System.out.println("Inside Setup");
		if (!testType.equalsIgnoreCase("API")) {
			initializeDriver();
		}
	}

	@AfterStep
	public void takescreenshot(Scenario scenario) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		// byte[] src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		// scenario.attach(src, "image/png", screenshotName);
	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Inside TearDown");

		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", screenshotName);
		}

		if (!testType.equalsIgnoreCase("API")) {
			closeDriver();
		}

	}

}
