Feature: Test

  Scenario Outline: Test1
    Given I navigate to Login page
    When I register whit my account
    And I go to send the new email
    And I send an email to "<User Name>" whit the subject of "<Subject>" and body "<Body>"
    Then The inbox mail is open

    Examples:
      | User Name                       | Subject       | Body    |
      | abner.mamani@fundacion-jala.org | Automation    | Hello   |




