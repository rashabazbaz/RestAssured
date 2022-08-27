package TestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@Test
	public void testMethod_1() {
		System.out.println("testMethod_1");
	}
	
	
	@Test
	public void testMethod_2() {
		System.out.println("testMethod_2");
	}
	
	
	@Test
	public void testMethod_3() {
		System.out.println("testMethod_3");
	}
	
	@Test
	public void testMethod_4() {
		System.out.println("testMethod_4");
	}
}
