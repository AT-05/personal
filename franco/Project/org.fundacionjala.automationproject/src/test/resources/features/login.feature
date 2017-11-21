@Login
Feature: Login
  Test successfully login in to the application

  @SmokeTest @Logout
  Scenario Outline: Login in to the application
    Given I navigate to Main Page
    When I login as "<Email_user>" with password "<Password>"
    Then I should login successfully

    Examples:
      | Email_user  | Password  |
      | faldunate   | password1 |
      | davidpotter | password2 |