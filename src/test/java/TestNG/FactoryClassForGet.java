package TestNG;

import java.util.List;

import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

import Core.ReadCsvFile;

public class FactoryClassForGet {
	@Parameters({"csv_path"})
	@Factory
	public Object[] factoryMethod(String csv_path) throws Exception {
		
		List<String[]> lines = ReadCsvFile.readAllLines(csv_path);
		lines.remove(0);
		Object[] data = new Object[lines.size()];
		int index = 0;
		for(String[] line : lines) {
			String url_prefex = line[0];
			String statusCode = line[1];
			data[index] = new TestGetWithFactory(url_prefex, statusCode);
			index++;
		}
		return data;
	}
}
