package api.endpoints;

public class Routes {

	
	//Base url= "https://petstore.swagger.io/;
	
	//Create USer(Post)="https://petstore.swagger.io/v2/user/createWithList";
	//Get USer(Get)="https://petstore.swagger.io/v2/user/{username}";
	//Update USer(put)="https://petstore.swagger.io/v2/user/{username}";
	//Delete USer(Delete)="https://petstore.swagger.io/v2/user/{username}";
	
	public static String baseUrl= "https://petstore.swagger.io/";
	
	public static String getUrl= baseUrl+"v2/user/{username}";
	public static String postUrl= baseUrl+"v2/user/{username}";
	public static String updateUrl= baseUrl+"v2/user/{username}";
	public static String putUrl= baseUrl+"v2/user/{username}";
	
	
	
}
