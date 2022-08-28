package Rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequestUsage {
	public int status_code;
	public String response_txt;
	public void runDelete(String url) {
		Response response = RestAssured.delete(url);
		this.status_code =response.getStatusCode();
		this.response_txt = response.asPrettyString();
	}
}
