Feature: createAnOrder

  @Login
  Scenario Outline: this scenario add an order in my account.
    Given I navigate to login page
    And I logIn with email "<Email_user>" and password "<Password>"
    When I search an product"<search>"
    And I select a items
    Then should be displayed

    Examples:
      | Email_user            | Password     | search     |
      | pedro.pablo@gmail.com | holamundo123 | dress     |
