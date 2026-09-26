# Question 3 – Alfagift Mobile UI Automation (Android)

UI automation for the Alfagift Android app using **Java**, **Appium**, **Cucumber (BDD)**, and the **Page Object Model (POM)** pattern.

## Scenario

```gherkin
Scenario: Customer views the detail of a searched product
  Given the customer is on the Alfagift home page
  When the customer searches for "indomie"
  And the customer opens the first product from the search results
  Then the product detail page should be displayed
  And the product name should match the selected product
```

The scenario covers a core e-commerce flow (search → results → product detail) without login/OTP or real payment, so it can be run repeatedly without side effects on the account.

## Tech Stack

- Java 17+
- Maven
- Appium 3 (UiAutomator2 driver) – `io.appium:java-client` 9.3.0
- Selenium 4.19.1
- Cucumber 7 + JUnit 4

## Project Structure

```
src/test/java
├── pages/             # Page Objects (BasePage, HomePage, SearchPage, SearchResultPage, ProductDetailPage)
├── runners/           # Cucumber runner (TestRunner)
├── stepdefinitions/   # Step definitions & hooks
└── utils/             # DriverManager (Appium driver setup)
src/test/resources
└── features/          # Gherkin feature file
```

## Prerequisites

1. JDK 17 or later and Maven installed
2. Node.js and Appium 3 with the UiAutomator2 driver:

```bash
npm install -g appium@3
appium driver install uiautomator2
```

3. Android SDK Platform Tools (`adb`)
4. An Android device with **USB debugging** enabled
5. Alfagift app installed from the Play Store and **already logged in** (the test uses `noReset: true`, so the existing session is kept)

## Setup

1. Clone the repository and open the `soal-3-alfagift-mobile-automation` folder.
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

2. From the `soal-3-alfagift-mobile-automation` folder, run:

```bash
mvn clean test
```

## Report

After the run, open `target/cucumber-reports/report.html` in a browser. A screenshot is attached to the report automatically when a scenario fails.

## Test Run Recording

[Watch the test run](https://drive.google.com/file/d/1oiRlIj08ocfPSno5tnom1sC4dgAfdiUp/view?usp=drive_link)
