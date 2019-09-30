@FunctionalTest
Feature: TestMe search functionality

  @SmokeTest
  Scenario: search functionality
    Given user has logged in TestmeApp
    When user searches for a product by typing four characters
    Then user gets all the suggestions
