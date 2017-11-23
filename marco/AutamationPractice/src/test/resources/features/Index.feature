@indexPage
Feature: IndexPage
  Scenario: This scenario verify the navigation to SingIn option
    Given I navigate to Index Page
    When I select SignIn option
    Then should be displayed Login page



