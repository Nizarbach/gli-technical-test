package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

    // Dijalankan OTOMATIS sebelum tiap Scenario mulai
    @Before
    public void setUp() {
        DriverManager.getDriver(); // pastikan session Appium sudah nyala
    }

    // Dijalankan OTOMATIS setelah tiap Scenario selesai (baik PASS maupun FAIL)
    @After
    public void tearDown() {
        DriverManager.quitDriver(); // tutup koneksi biar rapi
    }
}