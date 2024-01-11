package TestngTutorial.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestngTutorial.TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
	
	@Test(dataProvider = "getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		PrdouctCatalogue prdouctCatalogue = landingPage.LoginApplication(input.get("email"), input.get("password"));
		prdouctCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = prdouctCatalogue.goToCartPage();

		cartPage.VerifyProductDisplay(productName);

		CheckoutPage checkoutPage = cartPage.goToCheckout();

		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

		Assert.assertTrue(confirmationPage.getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		PrdouctCatalogue productCatalogue = landingPage.LoginApplication("rs_sty@gmail.com", "Rahulshetty@1");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap< String, String> map = new HashMap<String,String>();
//		map.put("email", "rs_sty@gmail.com");
//		map.put("password", "Rahulshetty@1");
//		map.put("product", "ADIDAS ORIGINAL");
//		
//
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "anik_shah@gmail.com");
//		map1.put("password", "Rahulshetty@1");
//		map1.put("product", "ADIDAS ORIGINAL");
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//TestngTutorial//data//PurchaseOreder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
//		   return new Object[][]  {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };
 
	}


}
