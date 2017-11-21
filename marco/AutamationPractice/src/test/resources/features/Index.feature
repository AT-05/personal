Feature: indexPage

  Scenario Outline: this scenario verify the navigation of Sing In option
    Given I navigate to Index Page
    When I press the option Sign In
    Then should be displayed Login page
    Examples:
      |  email|  pass |
      | marco |mendez |


