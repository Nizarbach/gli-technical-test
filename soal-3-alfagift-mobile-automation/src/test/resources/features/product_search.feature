@search
Feature: Product Search
  As an Alfagift customer
  I want to search for a product and view its details
  So that I can learn more about the item before buying it

  Scenario: Customer views the detail of a searched product
    Given the customer is on the Alfagift home page
    When the customer searches for "indomie"
    And the customer opens the first product from the search results
    Then the product detail page should be displayed
    And the product name should match the selected product