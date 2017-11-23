@Login
Feature: Login
  Test successfully login in to the application

  @SmokeTest
  Scenario Outline: Verify that a user can login in to the application
    Given I navigate to Main Page
    When I login as "<Email_user>" with password "<Password>"
    Then I should be redirected to home page

    Examples:
      | Email_user  | Password  |
      | faldunate   | password1 |
      | davidpotter | password2 |
      | andgomez    | password7 |