Feature: Purchase Products
  As a Swag Labs user
  I want to purchase products
  So that I can complete my order

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