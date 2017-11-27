@Register
Feature: As a user registered, It's be able to subscribe a free COURSE

  @Logout @Course @Subscribe
  Scenario: Verify that a user registered should be able to subscribe a free COURSE
    Given I navigate to Login page
    And I select Create new Account to go to Register page
    And I register with first name, last name, email and password
    When I select a free COURSE "C# For QA Automation Engineers with Selenium Webdriver"
    And enroll for free in the COURSE
    Then the COURSE subscribe should be displayed in My Dashboard