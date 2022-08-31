package TestNG;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Core.ReadCsvFile;
import Core.ReadJsonFile;
import Rest.DeleteRequestUsage;
import Rest.GetRequestUsage;
import Rest.PostRequestUsage;
import Rest.PutRequestUsage;

public class RestApiWithDP {
	static String csv_path;
	static String jsonPath;
	@Parameters({ "csv_path", "jsonPath" })
	@BeforeSuite
	public void beforeSuite(String csv_path, String jsonPath ) {
		RestApiWithDP.csv_path = csv_path;
		RestApiWithDP.jsonPath = jsonPath;

	}
	
	@DataProvider(name = "getCsvData")
	public static Object[][] getCsvData() throws Exception{
		
		List<String[]> lines = ReadCsvFile.readAllLines(RestApiWithDP.csv_path);
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for(String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}
	
	@DataProvider(name = "getJsonData")
	public static Object[][] getJsonData() throws Exception{
		
		String[] headers = {"method", "req_body", "url_prefex", "statusCode", "body"};
		JSONArray json_array =  ReadJsonFile.readFile(RestApiWithDP.jsonPath);
		Object[][] data = new Object[json_array.size()][headers.length];
		for(int i=0;i< json_array.size();i++) {
			JSONObject jo = (JSONObject) json_array.get(i);
			Object[] jsonData = new Object[headers.length];
			for(int j=0;j< headers.length;j++) {
				try {
					jsonData[j] = jo.get(headers[j]);
				}catch (Exception e) {
					jsonData[j] = null;
					// TODO: handle exception
				}

			}
			data[i]= jsonData;
		}
		return data;
	}
	
	
	@Test(enabled = true, dataProvider = "getCsvData")
	public void testGetDP(String url_prefex, String statusCode) {
		String url = "https://jsonplaceholder.typicode.com" + url_prefex;
		GetRequestUsage testGet = new GetRequestUsage();

		testGet.runGet(url);
		assertEquals(testGet.status_code, Integer.parseInt(statusCode));
	}
	
	@Test(dataProvider = "getJsonData")
	public void testRestDP(String method, JSONObject req_body, String url_prefex, long statusCode, JSONObject body) throws ParseException {
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
