Feature: Test send an email
  @LogOut
  Scenario Outline: Send an email with the registered user account
    Given I navigate to Login page
    When I register whit my account
    And I go to send the new email
    And I send an email to "<User Name>" whit the subject of "<Subject>" and body "<Body>"
    Then verify that the mail has arrived

    Examples:
      | User Name                       | Subject       | Body    |
      | abner.mamani@fundacion-jala.org | Automation2    | Hello   |
