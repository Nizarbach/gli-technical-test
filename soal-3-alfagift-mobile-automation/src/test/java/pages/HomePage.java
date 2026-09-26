package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Search bar di home. Dipakai untuk 2 hal: penanda sudah di home, dan target
    // tap.
    // Sengaja TIDAK pakai teks placeholder karena teksnya berganti-ganti.
    private final By searchBar = AppiumBy.id("com.alfamart.alfagift:id/clickable_search");

    // Dipakai di step "Given": pastikan home sudah tampil
    public boolean isHomePageDisplayed() {
        return isDisplayed(searchBar);
    }

    // Dipakai di step "When": buka layar pencarian
    public void tapSearchBar() {
        tap(searchBar);
    }
}