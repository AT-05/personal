Feature: Send Mail

  Background:
    Given I am logged to google mail

  @Logout @SendEmail
  Scenario Outline: Send an email to myself
    When I go to the Inbox page
      And I send an email to myself under the following subject "<Email_Subject>" and body "<Email_Body>"
    Then the email should be displayed in My Inbox list
    Examples:
      | Email_Subject | Email_Body                    |
      | AT05GUISend   | This email was send for    me |





