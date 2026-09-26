package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    private AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement cartIcon() {
        return driver.findElement(AppiumBy.accessibilityId("test-Cart"));
    }

    // Ini bagian "akal-akalan" buat elemen yang locator-nya duplikat.
    // Logikanya: "cari dulu container produk yang JUDULNYA cocok,
    // baru dari situ cari tombol ADD TO CART di dalamnya"
    private WebElement addToCartButtonByProductName(String productName) {
        String xpath = "//android.view.ViewGroup[@content-desc='test-Item']" +
                "[.//android.widget.TextView[@content-desc='test-Item title' and @text='" + productName + "']]" +
                "//android.view.ViewGroup[@content-desc='test-ADD TO CART']";
        return driver.findElement(AppiumBy.xpath(xpath));
    }

    public void addProductToCart(String productName) {
        addToCartButtonByProductName(productName).click();
    }

    public String getCartItemCount() {
        // Balikin teks angka yang ada di badge cart icon
        WebElement badge = driver.findElement(
                AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView")
        );
        return badge.getText();
    }

    public void tapCartIcon() {
        cartIcon().click();
    }
}