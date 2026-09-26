package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.DriverManager;

public class PurchaseSteps {

    private AndroidDriver driver = DriverManager.getDriver();

    private LoginPage loginPage = new LoginPage(driver);
    private ProductsPage productsPage = new ProductsPage(driver);
    private CartPage cartPage = new CartPage(driver);
    private CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("user is on the login page")
    public void userIsOnLoginPage() {
        // Nggak perlu aksi apa-apa, app emang default kebuka di login page
        // (berguna kalau nanti mau ditambah verifikasi screen)
    }

    @When("user logs in with username {string} and password {string}")
    public void userLogsIn(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user adds {string} to cart")
    public void userAddsProductToCart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Then("cart icon should show {string} items")
    public void cartIconShouldShowItems(String expectedCount) {
        String actualCount = productsPage.getCartItemCount();
        Assert.assertEquals(expectedCount, actualCount);
    }

    @When("user opens the cart")
    public void userOpensCart() {
        productsPage.tapCartIcon();
    }

    @Then("cart should contain {string}")
    public void cartShouldContain(String productName) {
        Assert.assertTrue(cartPage.isProductInCart(productName));
    }

    @When("user proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage.tapCheckout();
    }

    @When("user fills checkout information with first name {string}, last name {string}, and zip code {string}")
    public void userFillsCheckoutInformation(String firstName, String lastName, String zipCode) {
        checkoutPage.fillCheckoutInformation(firstName, lastName, zipCode);
    }

    @When("user continues to overview")
    public void userContinuesToOverview() {
        checkoutPage.tapContinue();
    }

    @When("user finishes the checkout")
    public void userFinishesCheckout() {
        checkoutPage.tapFinish();
    }

    @Then("order confirmation message {string} should be displayed")
    public void orderConfirmationMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}