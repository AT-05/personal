Feature: editPersonalInfo

  Scenario Outline: this scenario update the information personal of an account
    Given I navigate to login page and Sing In  with email "<Email_user>" and password "<oldPass>"
    When I do click in Edit Personal Info
    And I edit my information with"<firstName>","<lastName>","<oldPass>","<pass>","<confirmation>","<Day>","<Month>","<year>"
    Then should be displayedIdentify page

    Examples:
      | firstName     | lastName | oldPass       | pass         | confirmation | Email_user            | Day | Month | year |
      | Marta         | Perez    | holamundo123  | holamundo123 | holamundo123 | pedro.pablo@gmail.com | 10  | 10    | 2000 |
