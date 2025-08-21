package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;

//This class is to perform CRUD Operations- Create, Retrieve, Update,Delete
public class UserEndPointsFromRoutes {
	
	
	public static Response createUser(User payload) {
		
		Response response = given().log().all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.postUrl);
		
		return response;
				
	}

	
public static Response getUser(String Username) {
		
		Response response = given().log().all()
				.pathParam("username", Username)
				.when()
				.get(Routes.getUrl);
		
		return response;
				
	}

}
