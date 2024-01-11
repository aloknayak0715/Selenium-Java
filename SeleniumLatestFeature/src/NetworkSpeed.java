import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.ConnectionType;



public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devs = driver.getDevTools();
		devs.createSession();
		
		devs.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devs.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		driver.close();
	}

}
