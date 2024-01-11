package testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class FourthDemo {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite: ");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite: ");
	}
}
