
Feature: loginUser
  @Login
  Scenario Outline: this scenario verify the  users login
    Given I navigate to login page
    When I fill the field email "<Email_user>" and password "<Password>"
    Then should be displayed My Account page

    Examples:
      | Email_user                           | Password           |
      | pedro.pablo@gmail.com                | holamundo123       |
      | pedro.pablo13@gmail.com              | holamundo123       |
      | pablo.escobar13@gmail.com            | holamundo123       |
      | Chapo.Chapo13@gmail.com              | holamundo123       |