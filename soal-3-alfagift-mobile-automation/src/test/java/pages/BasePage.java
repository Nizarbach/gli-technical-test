package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected final AndroidDriver driver;
    protected final WebDriverWait wait;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        // Tunggu maksimal 15 detik sebelum menyerah mencari elemen
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Tunggu sampai elemen terlihat di layar, lalu kembalikan elemennya
    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Tunggu sampai minimal satu elemen terlihat, lalu kembalikan semuanya (untuk
    // list)
    protected List<WebElement> waitAllVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // Tunggu elemen bisa diklik, lalu tap
    protected void tap(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Tunggu elemen terlihat, kosongkan isinya, lalu ketik teks
    protected void type(By locator, String text) {
        WebElement element = waitVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Cek elemen tampil atau tidak, TANPA membuat test error kalau tidak ketemu
    protected boolean isDisplayed(By locator) {
        try {
            return waitVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}