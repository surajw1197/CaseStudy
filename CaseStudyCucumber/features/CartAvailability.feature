@FunctionalTest
Feature: Cart Availability

  @SmokeTest
  Scenario: User moves to cart without adding any item
    Given User is registered on testmeApp
    When User searches for the product like headphone
    And try to process the payment without adding any item in the cart
    Then TestMeApp doesnt display the cart icon
