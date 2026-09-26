package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

    // "driver" ini kayak remote control yang dipakai buat ngendaliin HP
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                // Isi capabilities sama persis kayak yang kita pakai di Appium Inspector
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");
                options.setUdid("RR8M70N4WGN"); // ganti kalau serial HP kamu beda
                options.setAppPackage("com.swaglabsmobileapp");
                options.setAppActivity("com.swaglabsmobileapp.MainActivity");
                options.setNoReset(true);

                // Alamat Appium server yang kita nyalain tadi
                URL appiumServerUrl = new URL("http://127.0.0.1:4723");

                driver = new AndroidDriver(appiumServerUrl, options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            } catch (Exception e) {
                e.printStackTrace();
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