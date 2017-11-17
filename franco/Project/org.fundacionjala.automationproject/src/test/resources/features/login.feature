@Login
Feature: Login
  Test successfully login in to the application

  @SmokeTest @Logout
  Scenario Outline: Login in to the application
    Given I navigate to Login page
    When I login as "<Email_user>" with password "<Password>"
    Then I should login successfully as "hi, johny smith"

  Examples:
  | Email_user            | Password           |
  | user@phptravels.com   | demouser           |