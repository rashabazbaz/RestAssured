package TestNG;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

import Core.ReadJsonFile;

public class FactoryClassForRest {
	@Parameters({"jsonPath"})
	@Factory
	public Object[] factoryMethod(String jsonPath) throws Exception {
		String[] headers = {"method", "req_body", "url_prefex", "statusCode", "body"};
		JSONArray json_array =  ReadJsonFile.readFile(jsonPath);
		Object[] data = new Object[json_array.size()];
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
			data[i] = new RestTestClass((String)jsonData[0], (JSONObject)jsonData[1],
					(String) jsonData[2],(Long) jsonData[3], (JSONObject)jsonData[4]);
		
		}
		return data;
	}
}
