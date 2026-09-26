package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URI;
import java.time.Duration;

public class DriverManager {

    // "driver" ini remote control yang dipakai untuk mengendalikan HP
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                // Capabilities: sama seperti JSON yang kita pakai di Appium Inspector
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");
                options.setUdid("RR8M70N4WGN"); // ganti kalau serial HP kamu beda
                options.setAppPackage("com.alfamart.alfagift");
                options.setNoReset(true); // jaga status login, tidak reset app
                options.setNewCommandTimeout(Duration.ofSeconds(300));

                // Alamat Appium server
                driver = new AndroidDriver(
                        URI.create("http://127.0.0.1:4723").toURL(), options);
            } catch (Exception e) {
                throw new RuntimeException("Gagal membuat koneksi ke Appium server", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}