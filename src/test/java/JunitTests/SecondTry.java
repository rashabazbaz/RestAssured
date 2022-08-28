package JunitTests;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Core.ReadCsvFile;
import Rest.GetRequestUsage;

public class SecondTry {
	static List<String[]> lines;
	static String url = "https://jsonplaceholder.typicode.com";
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		String path = "./testData.csv";
		
		lines = ReadCsvFile.readAllLines(path);
	}
	
	@Test
	public  void testGet() throws Exception {
		for (String[] line : lines) {
			if(line[0].contains("route")) {
				continue;
			}
			GetRequestUsage testGet = new GetRequestUsage();
			System.out.println(url + line[0]);
			testGet.runGet(url + line[0]);
			String statusCode =  line[1];
			Assert.assertEquals(testGet.status_code , Integer.parseInt(statusCode));
		}
	}
}
