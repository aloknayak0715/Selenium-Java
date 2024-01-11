package TestngTutorial.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TestngTutorial.TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest {

	String productName = "ZARA COAT 3";
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer = TestngTutorial.TestComponent.Retry.class)
	public void submitOrder() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		PrdouctCatalogue prdouctCatalogue = landingPage.LoginApplication("rs_sty@gmail.coms", "Rahulshetty@1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
//		driver.close();/
	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		PrdouctCatalogue productCatalogue = landingPage.LoginApplication("anik_shah@gmail.com", "Rahulshetty@1");
		List<WebElement> products = productCatalogue.getProducts();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}

	
	

}
