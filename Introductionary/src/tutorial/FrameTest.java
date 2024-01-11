package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//	driver.switchTo().frame(0); by index
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		Actions actions = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement targer = driver.findElement(By.id("droppable"));
		
		actions.dragAndDrop(source, targer).build().perform();
		driver.switchTo().defaultContent();
	}

}
