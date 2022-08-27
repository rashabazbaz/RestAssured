package TestNG;

import java.util.List;

import org.testng.annotations.Factory;

import Core.ReadCsvFile;

public class FactoryClass {
	@Factory
	public Object[] factoryMethod() throws Exception {
		String path = "parameterData.csv";
		List<String[]> lines = ReadCsvFile.readAllLines(path);
		lines.remove(0);
		Object[] data = new Object[lines.size()];
		int index = 0;
		for(String[] line : lines) {
			int firstInt = Integer.parseInt(line[0]);
			int secondInt = Integer.parseInt(line[1]);
			int maxInt = Integer.parseInt(line[2]);
			data[index] = new TestClassForFactory(firstInt, secondInt, maxInt);
			index++;
		}
		return data;
	}
}
