package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {

    // Kartu produk di hasil pencarian (id sama untuk semua kartu)
    private final By productCards = AppiumBy.id("com.alfamart.alfagift:id/card_product");

    // Nama produk di DALAM kartu
    private final By productName = AppiumBy.id("com.alfamart.alfagift:id/txt_product_name");

    // Ambil kartu produk pertama (index 0)
    private WebElement getFirstProductCard() {
        List<WebElement> cards = waitAllVisible(productCards);
        return cards.get(0);
    }

    // Dipakai di step "When": pastikan hasil pencarian sudah muncul
    public boolean isSearchResultDisplayed() {
        return isDisplayed(productCards);
    }

    // Ambil nama produk pertama, untuk disimpan lalu dibandingkan di halaman detail
    public String getFirstProductName() {
        return getFirstProductCard().findElement(productName).getText();
    }

    // Tap produk pertama untuk membuka halaman detail
    public void tapFirstProduct() {
        getFirstProductCard().click();
    }
}