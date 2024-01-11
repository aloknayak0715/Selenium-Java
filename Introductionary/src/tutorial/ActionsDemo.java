package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Actions actions = new Actions(driver);
		
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		actions.moveToElement(move).build().perform();
		actions.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	}

}
