package API_Demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {
	
	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		
		given().
		       param("hobbyName", "Singing").
		       get("/users").
		then().
		       statusCode(200).log().all();
		
	}
	
	@Test
	public void test_post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Sonali");
		request.put("lastName", "Kale");
		request.put("subjectID", "2");
		
		baseURI = "http://localhost:3000/";
		
		given().
		      header("Content-Type","application/json").
		      contentType(ContentType.JSON).
		      accept(ContentType.JSON).
		      body(request.toJSONString()).
		      
		when().
		      post("/users").
		then().
		      statusCode(201).log().all();
		
		
		
	}
	
	//@Test
		public void test_put() {
			
			JSONObject request = new JSONObject();
			
			request.put("firstName", "Sonali");
			request.put("lastName", "Kale");
			request.put("subjectID", "2");
			
			baseURI = "http://localhost:3000/";
			
			given().
			      header("Content-Type","application/json").
			      contentType(ContentType.JSON).
			      accept(ContentType.JSON).
			      body(request.toJSONString()).
			      
			when().
			      put("/users/4").
			then().
			      statusCode(200).log().all();
			
			
			
		}
	

}
