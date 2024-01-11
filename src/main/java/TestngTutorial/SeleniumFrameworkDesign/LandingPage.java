package TestngTutorial.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngTutorial.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement user = driver.findElement(By.id("userEmail")).sendKeys("rs_sty@gmail.com");
	//OR
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	

	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public PrdouctCatalogue LoginApplication(String userName, String userPass) {
		userEmail.sendKeys(userName);
		userPassword.sendKeys(userPass);
		login.click();
		
		PrdouctCatalogue prdouctCatalogue = new PrdouctCatalogue(driver);
		return prdouctCatalogue;
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() throws InterruptedException {
		Thread.sleep(100);
		return errorMessage.getText();
	}
}
