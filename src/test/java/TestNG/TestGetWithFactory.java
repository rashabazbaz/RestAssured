package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Rest.GetRequestUsage;

public class TestGetWithFactory {
	private String url_prefex;
	private String statusCode;
	
	public TestGetWithFactory(String url_prefex,String statusCode ) {
		this.statusCode = statusCode;
		this.url_prefex = url_prefex;
	}
	@Test
	public void testGet() {
		String url = "https://jsonplaceholder.typicode.com" + url_prefex;
		GetRequestUsage testGet = new GetRequestUsage();

		testGet.runGet(url);
		assertEquals(testGet.status_code, Integer.parseInt(statusCode));
	}
}
