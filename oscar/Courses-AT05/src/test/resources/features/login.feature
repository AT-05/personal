Feature: Login

  Scenario Outline: User should be able to login using valid credentials
    Given I navigate to Login page
    When I enter email "<Email_user>" with password "<Password>"
    Then The Home page should be displayed

    Examples:
      | Email_user        | Password     |
      | oscar@oscar.com   | password123  |