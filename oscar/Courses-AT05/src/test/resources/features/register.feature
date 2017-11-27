@Register
Feature: Register new user into application

  @Logout @NewUser
  Scenario: Verify that a user should be able to create account with valid credentials
    Given I navigate to Login page
    And I select Create new Account to go to Register page
    When I register with first name, last name, email and password
    Then the Home page should be displayed



