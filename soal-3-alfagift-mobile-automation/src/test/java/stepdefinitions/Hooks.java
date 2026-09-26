package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import utils.DriverManager;

public class Hooks {

    // Jalan OTOMATIS sebelum setiap skenario: nyalakan koneksi ke HP dan buka app
    @Before
    public void setUp() {
        DriverManager.getDriver();
    }

    // Jalan OTOMATIS setelah setiap skenario, baik lulus maupun gagal
    @After
    public void tearDown(Scenario scenario) {
        // Kalau skenario gagal, ambil screenshot dan tempelkan ke report
        if (scenario.isFailed() && DriverManager.getDriver() != null) {
            byte[] screenshot = DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot-saat-gagal");
        }
        DriverManager.quitDriver();
    }
}