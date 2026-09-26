package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.util.Map;

public class SearchPage extends BasePage {

    // Kolom input keyword. Dikunci dengan class EditText, karena id "edt_search"
    // juga dipakai di home sebagai TextView (placeholder) yang tidak bisa diketik.
    private final By searchInput = AppiumBy.androidUIAutomator(
            "new UiSelector()"
                    + ".resourceId(\"com.alfamart.alfagift:id/edt_search\")"
                    + ".className(\"android.widget.EditText\")");

    // Dipakai di step "When": ketik keyword lalu jalankan pencarian
    public void searchFor(String keyword) {
        type(searchInput, keyword);
        // Tekan tombol "Search" (kaca pembesar) di keyboard HP
        driver.executeScript("mobile: performEditorAction", Map.of("action", "search"));
    }
}