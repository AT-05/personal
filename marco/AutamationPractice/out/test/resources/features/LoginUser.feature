Feature: Log In User
  @Login
  Scenario Outline: This scenario verify  user's login
    Given I go to login page
    When I log In filling the field email "<Email_user>" and password "<Password>"
    Then should be displayed My Account page
    Examples:
      | Email_user                           | Password           |
      | pedro.pablo@gmail.com                | holamundo123       |
      | pedro.pablo13@gmail.com              | holamundo123       |
      | pablo.escobar13@gmail.com            | holamundo123       |
      | Chapo.Chapo13@gmail.com              | holamundo123       |