
Feature: AddNewAddress
  @DeleteAddress
  Scenario Outline: Add a new Address to your Address list.
    Given I navigate to login page
    And  I logIn with email "<Email_user>" and password "<Password>"
    When I delete an Address
    Then should be displayed Actualize My Address page
    Examples:
      | Email_user              | Password     |
      | pedro.pablo17@gmail.com | holamundo123 |