Feature: Delete email

  Background:
    Given I am logged to google mail

  @Logout
  Scenario Outline: Delete email with the specific subject
    Given I send an email to myself under subject "<Email_Subject>"and body "<Email_Body>"
    When I go to the Inbox  page
      And I delete this email
    Then the email should be removed from my Inbox email list
    Examples:
      | Email_Subject | Email_Body                    |
      | AT05GUIDel    | This email was send for    me |


