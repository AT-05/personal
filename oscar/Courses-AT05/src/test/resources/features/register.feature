Feature: Register

  Scenario Outline: User should be able to create account with valid credentials
    Given I navigate to Login page
    And I navigate to Register page
    When I enter first name "<First_name>", last name "<Last_name>", email "<Email_user>" and password "<Password>"
    Then The Home page should be displayed

    Examples:
      | First_name    | Last_name     | Email_user       | Password     |
      | oscar         | oz            | oscar1@oscar.com | password123  |