package TestNG;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Core.ReadCsvFile;
import Core.Square;

public class SquareDP {
	
	
	@DataProvider(name = "Data")
	public static Object[][] getData() throws Exception{
		
		List<String[]> lines = ReadCsvFile.readAllLines("testData2.csv");
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
	public void testData(String length, String area) {
		
		int lenInt = Integer.parseInt(length);
		int areaInt = Integer.parseInt(area);
		Square sq = new Square(lenInt);
		assertEquals(sq.calculateArea() , areaInt);
	}
}
