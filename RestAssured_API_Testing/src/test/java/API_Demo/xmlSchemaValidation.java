package API_Demo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;;

public class xmlSchemaValidation {
	
	@Test
	public void schemaValidation() throws IOException {
		
		
File file = new File("./SOAP Request/Add.XML");
	 	
	 	if (file.exists()) {
			System.out.println("  >> File Exist ");
		}
	 	
	 	FileInputStream fileInputStream = new FileInputStream(file)	;
	 	
	 	String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
	 		
	 	baseURI = "https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService";
	
	 	given().
	 		contentType("text/xml").                                //content type passing to the server is text/xml
	 		accept(ContentType.XML).                                //response should also be the same ContentTyoe.XML
	 		body(requestBody).
	 	when().
	 		post("/Calc.asmx").
	 	then().
	 		statusCode(200).log().all().
	 	and().
	 		body("//*:AddResult.text()", equalTo("7")).
	 	and(). 
	 		assertThat().body(matchesXsdInClasspath("Calculator.XSD"));
	 	
	 	
	}

}
