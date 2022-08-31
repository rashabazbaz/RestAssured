package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestClassForFactory {
	private int firstInt;
	private int secondInt;
	private int maxInt;
	
	public TestClassForFactory(int firstInt, int secondInt, int maxInt) {
		this.firstInt = firstInt;
		this.secondInt = secondInt;
		this.maxInt = maxInt;
	}
	
	@Test
	public void testData() {
		assertEquals(maxInt, Math.max(firstInt, secondInt));
	}
}
