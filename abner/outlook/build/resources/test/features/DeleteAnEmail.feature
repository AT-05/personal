#
#This feature is still in process, it is not finished
#


Feature: Test
  @LogOut
  Scenario Outline: Delete an email
    Given I navigate to Login page
    When I register whit my account
    And I delete an email whit the subject of "<Subject>"
    Then verify that the mail has delete

    Examples:
      | Subject       |
      | Automation2   |
