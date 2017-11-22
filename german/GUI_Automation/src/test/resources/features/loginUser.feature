@Login
Feature: Login

  @Logout
  Scenario Outline: Mail Login
    Given google mail page opened
    When I fill the field email "<Email_user>" and password "<Password>"
    Then should be displayed My Inbox page

    Examples:
      | Email_user        | Password      |
      | german.eduardo.qm | 1234567890111 |