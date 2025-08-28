package api.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Ultils.ExcelUtility;
import api.endpoints.UserEndPointsFromRoutes;
import api.endpoints.UserEndPointsFromProperties;
import api.payload.User;
import io.restassured.response.Response;

public class UserTestsRoutes {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void SetupData() {
		
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(0);
		userPayload.setUsername("shobanaprakash");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));		
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStatus(0);	
		
		
	}
	
	//@Test
	public void testPostUSer() {
		
		Response response =UserEndPointsFromRoutes.createUser(userPayload);
		response.then().log().all();	
		
		
	}
	
	
	//@Test
	public void testGetUSer() throws IOException {
		
		Response response =UserEndPointsFromProperties.getUser("Shobanaaaaaa");
		response.then().log().all();	
		response.statusCode();
		Assert.assertEquals(response.statusCode(), 200);
		
		ExcelUtility excelUtil=new ExcelUtility("C:\\Users\\Shoban\\eclipse-workspace\\NewProject\\NewProject1\\CucumberTestNG\\TestData.xlsx");
		
		String cellData=excelUtil.getCellValue("Sheet1");
		
		System.out.println("===Cell Data==="+cellData);
		
	}
	
}
