package API_Demo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class JsonScehmaValidator {
	
@Test	
public void test_get() {
		
		baseURI = "https://reqres.in/api";
		
		given().
		       get("/users?page=2/").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		       statusCode(200).log().all().
		       body("data[4].first_name", equalTo("George")).
		       body("data.first_name", hasItems("George", "Rachel"));

}


}
