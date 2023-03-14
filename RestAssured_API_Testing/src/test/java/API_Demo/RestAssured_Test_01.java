package API_Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

public class RestAssured_Test_01 {

	@Test
	void test01_Get() {
		
		Response response = get("http://localhost:3000/users");
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getBody());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		
		int Statuscode= response.getStatusCode();
		Assert.assertEquals(Statuscode, 200);
		
		
	}
	
	@Test
	void test02() {	
		
	 given().
	 get("https://reqres.in/api/users/2").then().statusCode(200).
	 body("data.email", equalTo("janet.weaver@reqres.in")).log().all();
	 
	}

	public void test03() {
		given().get("http://localhost:3000/data").then().statusCode(200).
		body("users[1].firstName", equalTo("Kapil")).log().all();
	}
	
}
