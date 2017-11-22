@Search
Feature: Register

  Scenario: User should be able to search courses with the name
    Given I navigate to all courses page
    When I search course with the name "Page Objects in Test Automation"
    Then the course with that name should be displayed