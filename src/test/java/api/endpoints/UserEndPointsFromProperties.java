package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.Properties;

import Ultils.PropertiesUtil;
import api.payload.User;

//This class is to perform CRUD Operations- Create, Retrieve, Update,Delete
public class UserEndPointsFromProperties {
	
	
	static Properties prop = PropertiesUtil.loadConfigProperties();
	//String testType = prop.get("TestType").toString();
	
	
public void setup() {

		
		System.out.println("Inside Setup");
		
	}
	
	public static Response createUser(User payload) {
		
		Response response = given().log().all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(prop.get("postUrl").toString());
		
		return response;
				
	}

	
public static Response getUser(String Username) {
		
	
		Response response = given().log().all()
				.pathParam("username", Username)
				.when()
				.get(prop.get("getUrl").toString()); 
		
		return response;
				
	}

}
