package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestWithParameters {
	@Parameters({ "first", "second" })
	@Test
	public void testWithParams(String first, String second) {
		assertEquals(first, second);
	}
}
