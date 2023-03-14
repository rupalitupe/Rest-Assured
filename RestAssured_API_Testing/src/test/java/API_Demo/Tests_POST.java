package API_Demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;

public class Tests_POST {
	
	@Test
	public void test_01_post() {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("name", "Rupali");
		map.put("job", "Teacher");
		
		JSONObject request = new JSONObject(map);
		
		System.out.println(request);
		given().
               header("Content-Type", "application/json").
               body(request.toJSONString()).
        when().
               post("https://reqres.in/api/users").
               
        then().
               statusCode(201).log().all();
                 	
	}
	

}
