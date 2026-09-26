package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement checkoutButton() {
        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().descriptionContains(\"test-CHECKOUT\"))";
        return driver.findElement(AppiumBy.androidUIAutomator(uiScrollable));
    }

    // Cek apakah nama produk tertentu muncul di dalam cart
    public boolean isProductInCart(String productName) {
        try {
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + productName + "']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void tapCheckout() {
        checkoutButton().click();
    }
}