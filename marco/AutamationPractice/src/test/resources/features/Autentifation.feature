Feature: authentication

  Scenario Outline: verification of the new Email
    Given I navigate to MainPage
    When I put the new email"<newEmail>"
    Then should be create page displayed

  Examples:
    | newEmail              |
    | pedro2.pablo@gmail.com|