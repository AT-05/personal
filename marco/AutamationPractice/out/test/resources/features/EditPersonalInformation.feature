Feature: Edit Personal Information
  @EditInfo
  Scenario Outline: this scenario update the information personal of an account
    Given I go to login page
    And I logIn with email "<Email_user>" and password "<oldPass>"
    When I select Edit Personal Info option
    And I edit the fields with the following data"<firstName>","<lastName>","<oldPass>","<pass>","<confirmation>","<Day>","<Month>","<year>"
    Then should be displayed Identify page
    Examples:
      | firstName     | lastName         | oldPass      | pass         | confirmation | Email_user              | Day | Month | year |
      | Baltazar      | Tacuchaba Paraba | holamundo123 | holamundo123 | holamundo123 | pedro.pablo@gmail.com   | 10  | 10    | 2000 |
      | Marco Antonio | Mendez Rocha     | holamundo123 | holamundo123 | holamundo123 | Chapo.Chapo15@gmail.com | 10  | 10    | 2000 |
