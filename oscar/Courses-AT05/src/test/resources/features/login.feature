@Login
Feature: Login

  @Logout
  Scenario Outline: User should be able to login using valid credentials
    Given I navigate to Login page
    When I login with email "<Email_user>" and password "<Password>"
    Then the Home page should be displayed

    Examples:
      | Email_user        | Password     |
      | oscar@oscar.com   | password123  |
#      | oscar2@oscar.com  | password123  |

