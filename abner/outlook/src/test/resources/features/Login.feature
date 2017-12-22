@Email
Feature: Email

  @LogOut
  Scenario Outline: The user must register with their credentials
    Given I navigate to Login page
    When I enter correct credentials, as user "<User Name>" and password "<Password>"
    Then The inbox mail is open

    Examples:
      | User Name                       | Password  |
      | abner.mamani@fundacion-jala.org | Cream.com |
      | abner.mamani@fundacion-jala.org | Cream.com |

