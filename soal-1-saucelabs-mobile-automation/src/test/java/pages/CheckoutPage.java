package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private AndroidDriver driver;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // --- Elemen di Checkout: Information ---
    private WebElement firstNameField() {
        return driver.findElement(AppiumBy.accessibilityId("test-First Name"));
    }

    private WebElement lastNameField() {
        return driver.findElement(AppiumBy.accessibilityId("test-Last Name"));
    }

    private WebElement zipCodeField() {
        return driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code"));
    }

    private WebElement continueButton() {
        return driver.findElement(AppiumBy.accessibilityId("test-CONTINUE"));
    }

    // --- Elemen di Checkout: Overview ---
    private WebElement finishButton() {
        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().descriptionContains(\"test-FINISH\"))";
        return driver.findElement(AppiumBy.androidUIAutomator(uiScrollable));
    }

    // --- Elemen di Checkout: Complete ---
    private WebElement confirmationMessage() {
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']"));
    }

    // --- Method Aksi ---
    public void fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        firstNameField().sendKeys(firstName);
        lastNameField().sendKeys(lastName);
        zipCodeField().sendKeys(zipCode);
    }

    public void tapContinue() {
        continueButton().click();
    }

    public void tapFinish() {
        finishButton().click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage().getText();
    }
}