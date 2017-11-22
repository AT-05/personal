@Register
Feature: Register

  @Logout @User
  Scenario: User should be able to create account with valid credentials
    Given I navigate to Login page
    And I navigate to Register page
    When I register with first name, last name, email and password
    Then the Home page should be displayed


  @Logout @Course
  Scenario: User registered should be able to subscribe a free COURSE
    Given I navigate to Login page
    And I navigate to Register page
    And I register with first name, last name, email and password
    When I select a free COURSE "C# For QA Automation Engineers with Selenium Webdriver"
    And enroll for free in the COURSE
    Then the COURSE subscribe should be displayed in My Dashboard
