import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NOT WORKING
		ChromeDriver driver = new ChromeDriver();
//		
//		Predicate<URI>  uriPredicate = uri -> uri.getHost().contains("https://httpbin.org/");	
//		
//		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
//
//		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
		//2nd Method - working
		// use http://username:password@url  ex: http://admin:admin@the-internet.herokuapp.com/
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
	}

}
