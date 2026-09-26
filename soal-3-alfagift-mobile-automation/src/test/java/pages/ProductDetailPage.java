package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage {

    // Penanda halaman detail. Elemen ini khusus ada di halaman detail,
    // jadi lebih bisa dipercaya daripada nama produk (id-nya juga ada di hasil
    // pencarian).
    private final By stockStatus = AppiumBy.id("com.alfamart.alfagift:id/status_stock");

    // Nama produk di halaman detail
    private final By productName = AppiumBy.id("com.alfamart.alfagift:id/txt_product_name");

    // Dipakai di step "Then": pastikan halaman detail tampil
    public boolean isProductDetailDisplayed() {
        return isDisplayed(stockStatus);
    }

    // Dipakai di step "Then": ambil nama produk untuk dibandingkan
    public String getProductName() {
        return waitVisible(productName).getText();
    }
}