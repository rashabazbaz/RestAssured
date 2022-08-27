package ReviewCode;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class TestClass {
	
	
	
	@Test(alwaysRun = true)
	public void testMethod() {
		assertTrue(false);
	}
	
	@Test(enabled = true, dependsOnMethods = {"testMethod"})
	public void testMethod3() {
		
	}
	
}
