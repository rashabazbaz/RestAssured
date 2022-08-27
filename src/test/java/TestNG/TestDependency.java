package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestDependency {
	@Test(dependsOnMethods = {"firstTest"}, alwaysRun = true)
	public void testMethod() {
		
	}
	
	@Test(dependsOnGroups = {"negative"})
	public void firstTest() {
		assertEquals("test", "tesssst");
	}
	
	
	@Test(groups = {"negative"})
	public void testNegative() {
		
	}
	
	@Test(groups = {"negative"})
	public void testNegative2() {
		
	}
	
	
}
