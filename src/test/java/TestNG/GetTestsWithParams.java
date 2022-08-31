package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Rest.GetRequestUsage;

public class GetTestsWithParams {
	
	@Parameters({"url_prefex","statusCode"})
	@Test(enabled = true)
	public void testGetDP(String url_prefex, String statusCode) {
		String url = "https://jsonplaceholder.typicode.com" + url_prefex;
		GetRequestUsage testGet = new GetRequestUsage();

		testGet.runGet(url);
		assertEquals(testGet.status_code, Integer.parseInt(statusCode));
	}
}
