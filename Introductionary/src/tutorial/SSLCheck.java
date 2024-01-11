package tutorial;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
	public static void main(String args[]) throws InterruptedException {
		//show it to Umesh and Manish
		ChromeOptions options = new ChromeOptions();
		//can add extension as well 
		//options.addExtension("");
		
//		you can add proxy as well
//		Proxy proxy = new Proxy();
//		proxy.setHttpProxy("ipaddress:portnumber");
//		options.setCapability("proxy", proxy);
		
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
//		driver.get("https://expired.badssl.com/");
		driver.get("https://ec2-35-176-202-4.eu-west-2.compute.amazonaws.com/");
		Thread.sleep(8000);
	}
}
