package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demo {

	@Test
	public void start() {
		System.out.println("Hello");
	}
	
	@Test(groups= {"Smoke"})
	public void end() {
		System.out.println("End");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Everme Test method in demo class: ");
	}
	
	@AfterMethod
	public void afteMethod() {
		System.out.println("After Method in demo class");
	}
	
}
