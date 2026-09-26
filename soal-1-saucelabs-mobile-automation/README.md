# Question 1 – Swag Labs Mobile UI Automation (Android)

UI automation for the Sauce Labs sample app (**Swag Labs**) using **Java**, **Appium**, **Cucumber (BDD)**, and the **Page Object Model (POM)** pattern.

## Scenario

```gherkin
Scenario: Successfully purchase Sauce Labs Backpack and Bike Light
  Given user is on the login page
  When user logs in with username "standard_user" and password "secret_sauce"
  And user adds "Sauce Labs Backpack" to cart
  And user adds "Sauce Labs Bike Light" to cart
  Then cart icon should show "2" items
  When user opens the cart
  Then cart should contain "Sauce Labs Backpack"
  And cart should contain "Sauce Labs Bike Light"
  When user proceeds to checkout
  And user fills checkout information with first name "John", last name "Doe", and zip code "12345"
  And user continues to overview
  And user finishes the checkout
  Then order confirmation message "THANK YOU FOR YOU ORDER" should be displayed
```

The scenario covers the full purchase flow: login → add products to cart → verify cart → checkout → order confirmation.

## Tech Stack

- Java 17+
- Maven
- Appium 3 (UiAutomator2 driver) – `io.appium:java-client` 9.3.0
- Selenium 4.19.1
- Cucumber 7 + JUnit 4

## Project Structure

```
src/test/java
├── pages/             # Page Objects (LoginPage, ProductsPage, CartPage, CheckoutPage)
├── runners/           # Cucumber runner (TestRunner)
├── stepdefinitions/   # Step definitions & hooks
└── utils/             # DriverManager (Appium driver setup)
src/test/resources
└── features/          # Gherkin feature file
```

Elements are located mainly by **accessibility id** (e.g. `test-Username`, `test-LOGIN`, `test-CHECKOUT`), which the Swag Labs app provides for testing.

## Prerequisites

1. JDK 17 or later and Maven installed
2. Node.js and Appium 3 with the UiAutomator2 driver:

```bash
npm install -g appium@3
appium driver install uiautomator2
```

3. Android SDK Platform Tools (`adb`)
4. An Android device with **USB debugging** enabled
5. Swag Labs sample app installed on the device. The Android APK is available on the [Sauce Labs sample app releases page](https://github.com/saucelabs/sample-app-mobile/releases). Install it with:

```bash
adb install path/to/Android.SauceLabs.Mobile.Sample.app.apk
```

## Setup

1. Clone the repository and open the `soal-1-saucelabs-mobile-automation` folder.
2. Connect the device and check its serial number:

```bash
adb devices
```

3. Set the serial number in `src/test/java/utils/DriverManager.java`:

```java
options.setUdid("YOUR_DEVICE_SERIAL");
```

## How to Run

1. Start the Appium server in a separate terminal:

```bash
appium
```

2. From the `soal-1-saucelabs-mobile-automation` folder, run:

```bash
mvn clean test
```

## Report

After the run, open `target/cucumber-reports/report.html` in a browser.

## Test Run Recording

[Watch the test run](https://drive.google.com/file/d/13gPGXcsCL67mqY7HjYg0HwyXUI4xGcDx/view?usp=drive_link)
