package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private AndroidDriver driver;

    // Constructor: setiap Page Object butuh "driver" biar bisa ngendaliin HP
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locator - alamat tiap elemen yang kita ambil dari Appium Inspector kemarin
    private WebElement usernameField() {
        return driver.findElement(AppiumBy.accessibilityId("test-Username"));
    }

    private WebElement passwordField() {
        return driver.findElement(AppiumBy.accessibilityId("test-Password"));
    }

    private WebElement loginButton() {
        return driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
    }

    // Method aksi - ini yang nanti dipanggil dari Step Definitions
    public void enterUsername(String username) {
        usernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField().sendKeys(password);
    }

    public void tapLoginButton() {
        loginButton().click();
    }

    // Method gabungan biar Step Definitions lebih ringkas
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLoginButton();
    }
}