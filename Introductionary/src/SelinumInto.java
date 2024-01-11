import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelinumInto {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrom.driver", "/Eclipse/Driver/chromedriver-win64/chromedriver-win64");
		WebDriver driver = new ChromeDriver();
//		WebDriver driver  = new EdgeDriver();
//		WebDriver driver1 = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
