package Rest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostRequestUsage {
	public int status_code;
	public String response_txt;
	public void runPost(String baseUrl,String route, String request_body) {
		RestAssured.baseURI =baseUrl; 
		RequestSpecification request = RestAssured.given().body(request_body); 
		request.header("Content-Type", "application/json"); 
		Response response = request.post(route); 
		ResponseBody body = response.getBody();
		this.status_code =  response.getStatusCode();
		this.response_txt = body.asString();
		
	}
}
