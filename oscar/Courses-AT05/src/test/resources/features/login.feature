@Login
Feature: As a user registered is be able to login into application

  @Logout
  Scenario Outline: Verify that a user should be able to login using valid credentials
    Given I navigate to Login page
    When I login with name "<First_Name>", last name "<Last_Name>", email "<Email_user>" and password "<Password>"
    Then the Home page should be displayed

    Examples:
      | First_Name   | Last_Name     | Email_user        | Password     |
      | Oscar        | Delgadillo    | oscar@test.com    | password123  |

