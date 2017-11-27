Feature: authentication
  Scenario: Check if an new is validate for create an new account
    Given I navigate to MainPage
    When I put the new email
    Then should be displayed create page

