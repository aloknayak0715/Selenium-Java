package tutorial;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 
		// delete particular key or session key so that you can click on any link it lead to login session
//		driver.manage().deleteCookieNamed("sessionKey");
		driver.get("https://www.google.com/");
		
		//screenshot
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src,"C://Users//alok.nayak//screenshot.png");
	}

}
