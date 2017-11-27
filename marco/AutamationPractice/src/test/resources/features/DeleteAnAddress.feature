Feature: AddNewAddress
  Background:
    Given I go to login page
      And  I logIn with email  and password
  @AddNewAddress
  Scenario: Verify the delete a new Address to your Address list.
    When I select Delete an Address option
      And I delete an address
    Then should be displayed Actualize My Address page
