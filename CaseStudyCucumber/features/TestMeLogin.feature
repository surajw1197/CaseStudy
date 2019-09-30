@LoginFunctionality
Feature: Login Functionality

  @SmokeTest
  Scenario Outline: TestMeApp multiple login Functionality
    Given User is on TestMeApp Login Page
    When User provides "<username>" and "<password>"
    Then Display message Logged-in successfully

    Examples: 
      | username  | password     |
      | suraj0024 | suraj0024    |
      | suraj024  | suraj024     |
