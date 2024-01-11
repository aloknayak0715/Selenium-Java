import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class GeoLocationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String, Object> cordinates = new HashMap<String, Object>();
		cordinates.put("latitude", 40);
		cordinates.put("longitude", 3);
		cordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", cordinates);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElement(By.xpath("//h3[contains(text(),'Netflix - Watch TV Shows Online, Watch Movies Onli')]")).click();
	}

}
