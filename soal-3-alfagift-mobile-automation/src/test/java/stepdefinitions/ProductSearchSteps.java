package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class ProductSearchSteps {

    // Menyimpan nama produk yang dipilih di hasil pencarian,
    // untuk dibandingkan dengan nama di halaman detail
    private String selectedProductName;

    @Given("the customer is on the Alfagift home page")
    public void theCustomerIsOnTheAlfagiftHomePage() {
        HomePage homePage = new HomePage();
        Assert.assertTrue("Home page tidak tampil", homePage.isHomePageDisplayed());
    }

    @When("the customer searches for {string}")
    public void theCustomerSearchesFor(String keyword) {
        new HomePage().tapSearchBar();
        new SearchPage().searchFor(keyword);
    }

    @When("the customer opens the first product from the search results")
    public void theCustomerOpensTheFirstProductFromTheSearchResults() {
        SearchResultPage resultPage = new SearchResultPage();
        Assert.assertTrue("Hasil pencarian tidak tampil", resultPage.isSearchResultDisplayed());

        selectedProductName = resultPage.getFirstProductName();
        resultPage.tapFirstProduct();
    }

    @Then("the product detail page should be displayed")
    public void theProductDetailPageShouldBeDisplayed() {
        Assert.assertTrue("Halaman detail produk tidak tampil",
                new ProductDetailPage().isProductDetailDisplayed());
    }

    @Then("the product name should match the selected product")
    public void theProductNameShouldMatchTheSelectedProduct() {
        String detailProductName = new ProductDetailPage().getProductName();
        Assert.assertEquals("Nama produk di halaman detail tidak sama dengan yang dipilih",
                selectedProductName, detailProductName);
    }
}