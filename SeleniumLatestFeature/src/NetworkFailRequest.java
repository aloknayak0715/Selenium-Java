import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v118.network.model.RequestPattern;
import org.openqa.selenium.devtools.v120.fetch.Fetch;
import org.openqa.selenium.devtools.v120.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v120.network.model.ErrorReason;
//import org.openqa.selenium.devtools.v120.network.model.RequestPattern;

public class NetworkFailRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		devtools.send(Fetch.enable(patterns, Optional.empty()));
		
		devtools.addListener(Fetch.requestPaused(), request -> {
			devtools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED)); 
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	
	}

}
