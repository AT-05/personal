Feature: Delete

  Background:
    Given I am logged to google mail

  @Logout
  Scenario: Delete mail
    Given I have a email received
    When I go to the Inbox received page
      And I delete the email with subject "AT05GUI"
    Then the email be removed from the Inbox email list