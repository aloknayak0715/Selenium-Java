package testng;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class SecondDemo {

	@Parameters({"URL","API/username"})
	@Test()
	public void TestM(String urlName,String key) {
		System.out.println("new:");
		System.out.println("urLNm: "+urlName);
		System.out.println("key: "+key);
	}
	
	@BeforeTest
	public void prerequisite() {
		System.out.println("Execute First");
	}
	
	@AfterTest
	public void last() {
		System.out.println("I will execute last");
	}
}
