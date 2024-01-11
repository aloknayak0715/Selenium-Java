import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devTool = driver.getDevTools();

		//listener - on test faiure

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entries =  driver.manage().logs().get(LogType.BROWSER); // get enteries object
		List<LogEntry> log = entries.getAll(); // return all log in list
		//iterating through log
		for(LogEntry e: log) {
			System.out.println("LogEntry: "+e.getMessage());
		}
	}

}
