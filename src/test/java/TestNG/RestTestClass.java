package TestNG;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Rest.DeleteRequestUsage;
import Rest.PostRequestUsage;
import Rest.PutRequestUsage;

public class RestTestClass {
	private String method;
	private JSONObject req_body;
	private String url_prefex;
	private long statusCode;
	private JSONObject body;
	public RestTestClass(String method, JSONObject req_body, String url_prefex, long statusCode, JSONObject body) {
		this.method = method;
		this.req_body = req_body;
		this.url_prefex = url_prefex;
		this.statusCode = statusCode;
		this.body = body;
		
	}
			
			
	@Test
	public void testRestApis() throws ParseException {
		String baseUrl = "https://jsonplaceholder.typicode.com";
		if(method.equals("POST")) {
			PostRequestUsage testPost = new PostRequestUsage();
			testPost.runPost(baseUrl, url_prefex, req_body.toJSONString());
			assertEquals(testPost.status_code, (int) statusCode);
			if((statusCode+"").startsWith("2")) {
				JSONObject actualBody =  (JSONObject) new JSONParser().parse(testPost.response_txt);
				assertEquals(actualBody, body);
			}
		}else if(method.equals("PUT")) {
			PutRequestUsage testPut = new PutRequestUsage();
			testPut.runPost(baseUrl, url_prefex, req_body.toJSONString());
			
			

			assertEquals(testPut.status_code, (int) statusCode);
			if((statusCode+"").startsWith("2")) {
				JSONObject actualBody =  (JSONObject) new JSONParser().parse(testPut.response_txt);
				assertEquals(actualBody, body);
			}
			
		}else if(method.equals("DELETE")) {
			DeleteRequestUsage testDelete = new DeleteRequestUsage();
			testDelete.runDelete(baseUrl+url_prefex);
			assertEquals(testDelete.status_code, (int) statusCode);
		}
		
	}
}
