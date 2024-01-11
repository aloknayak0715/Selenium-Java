package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThirdDemo {

	@BeforeClass
	public void beforeClass() {
	System.out.println("Before Class only scope is class");	
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after Class only scope is class");	
		}
		
	@Parameters({"sss","API/username"})
	@Test(groups= {"Smoke"})
	public void WebLoginCarLoan(String ss,String key) {
		//selenium
		System.out.println("webloginCar");
		System.out.println("SSSO: "+ss);
		System.out.println("Key in 3rd: "+key);
	}
	
	@Test(enabled = false)
	public void MobileLoginCarLoan() {
		System.out.println("MobileLoginCar");
	}

	@Test(dependsOnMethods = {"LoginApiLoan"})
	public void MobileLoginCarLoanAA() {
		System.out.println("MobileLoginCar1");
	}
	
	@Test(timeOut = 4000)
	public void LoginApiLoan() {
		System.out.println("ApiLoginCar");
	}
	
	@Test(dataProvider = "getData")
	public void printData(String user, String pass) {
		System.out.println("username: "+user);
		System.out.println("password: "+pass);
	}
	
	@DataProvider
	public Object[][] getData() {
		//1st combination - username and password - good redit history
		//2nd combination - username and pass - no credit history
		//3rd fradulent history
		Object[][] data = new Object[3][2];
		//1st data
		data[0][0] = "firstUserName";
		data[0][1] = "pass";
		
		//column in row nothing but values for particular combination
		//2nd data set
		data[1][0] = "secondUserName";
		data[1][1]= "secondPassword";
		
		//3rd data set
		data[2][0] = "thirdUserName";
		data[2][1] = "thirdPassword";
		
		return data;
	}
}
