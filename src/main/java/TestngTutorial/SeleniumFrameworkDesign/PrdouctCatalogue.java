package TestngTutorial.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestngTutorial.AbstractComponents.AbstractComponent;

public class PrdouctCatalogue extends AbstractComponent {

	WebDriver driver;
	
	public PrdouctCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productBy = By.cssSelector(".mb-3");
	By cartProduct = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By loadingAnimation = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProducts() {
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
	WebElement product =	getProducts().stream().filter(prod -> 
		prod.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return product;
	}
	
	public void addProductToCart(String productName) {
		getProductByName(productName).findElement(cartProduct).click();	
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(loadingAnimation);
	}


}
