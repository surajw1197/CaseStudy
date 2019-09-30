@FunctionalTest
Feature: Registration Functionality

  @SmokeTest
  Scenario: TestMeApp Registration functionality
    Given user is on home page
    When user clicks on signup
    And user enter the registration creds
      | suraj24 | suraj | waichale | suraj24 | suraj24 | Male | s@gmail.com | 7894561230 | Sep | 10 | 1997 | hinjewadi, pune | What is your Birth Place? | latur |
    Then Registration successfull
