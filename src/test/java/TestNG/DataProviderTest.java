package TestNG;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Core.ReadCsvFile;

public class DataProviderTest {
	static String path;
	@Parameters({ "filePath" })
	@BeforeSuite
	public void beforeSuite(String filePath) {
		DataProviderTest.path = filePath;
	}
	
	@DataProvider(name = "Data")
	public static Object[][] getData() throws Exception{
		
		List<String[]> lines = ReadCsvFile.readAllLines(DataProviderTest.path);
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for(String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}
	@Test(dataProvider = "Data")
	public void testData(String first, String second, String Max) {
		int firstInt = Integer.parseInt(first);
		int secondInt = Integer.parseInt(second);
		int maxInt = Integer.parseInt(Max);
		assertEquals(Math.max(firstInt, secondInt) , maxInt);
	}
}
