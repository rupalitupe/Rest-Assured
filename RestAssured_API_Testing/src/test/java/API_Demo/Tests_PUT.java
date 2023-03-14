package API_Demo;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Tests_PUT {
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
              put("https://reqres.in/api/users/2").
        then().
               statusCode(200).log().all();
                 
		
}
}
