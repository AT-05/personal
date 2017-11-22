Feature: Send

  Background:
    Given I am logged to google mail

  @Logout
  Scenario: Send mail
    When I go to the Inbox page
    And I sent a new for to me with the following subject :"AT05GUI"

    Then the email send should be displayed in the Inbox list





