import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.emulation.Emulation;
import org.openqa.selenium.devtools.v120.fetch.Fetch;
import org.openqa.selenium.devtools.v120.network.Network;

public class NetworkMocking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		
		dev.createSession();
		dev.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		dev.addListener(Fetch.requestPaused(), request -> {
			if(request.getRequest().getUrl().contains("shetty")) {
				String mockUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println("newUrl: "+mockUrl);
				
				// sometime value will be empty but so we are using Optional.empty() instead of null
				dev.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockUrl) , 
						Optional.of(request.getRequest().getMethod()), 
						Optional.empty(), Optional.empty(),Optional.empty()));
			}
			else {
				dev.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()) , 
						Optional.of(request.getRequest().getMethod()), 
						Optional.empty(), Optional.empty(),Optional.empty()));
		
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	
	}

}
