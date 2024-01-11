package TestngTutorial.stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import TestngTutorial.SeleniumFrameworkDesign.CartPage;
import TestngTutorial.SeleniumFrameworkDesign.CheckoutPage;
import TestngTutorial.SeleniumFrameworkDesign.ConfirmationPage;
import TestngTutorial.SeleniumFrameworkDesign.LandingPage;
import TestngTutorial.SeleniumFrameworkDesign.PrdouctCatalogue;
import TestngTutorial.TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderStepDefinition extends BaseTest {

	public LandingPage landingPage;
	public PrdouctCatalogue prdouctCatalogue ;
	public ConfirmationPage confirmationPage ;
	public CheckoutPage checkoutPage;
	public CartPage cartPage;
	
	@Given("I landed on Ecommerce Page")
	public void landed_On_WebPage() throws IOException {
		
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_In_With_UserName_And_Password(String username, String password) {
		 prdouctCatalogue = landingPage.LoginApplication(username, password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void Add_Product_To_Cart(String productName) {
		prdouctCatalogue.addProductToCart(productName);
	}
	
	//For And both workd @And and @When
	@When("^Checkout (.+) and submit the order$")
	public void submit_order(String productName) {
		cartPage = prdouctCatalogue.goToCartPage();
		cartPage.VerifyProductDisplay(productName);

		 checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		confirmationPage = checkoutPage.submitOrder();

	}
	
    @Then("{string} message is displayed on ConfirmationPage")
	public void confitmation_message(String string) {
		Assert.assertTrue(confirmationPage.getConfirmationMessage().equalsIgnoreCase(string));
	}
}
