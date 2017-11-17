Feature: loginUser

  Scenario Outline: this scenario verify the  users login
    Given I navigate to login page
    When I fill the field email "<Email_user>" and password "<Password>"
    Then should be displayed My Account page
    And should be closed the page

  Examples:
  | Email_user                           | Password           |
  | marco.mendez15935@fundacion-jala.org | holamundo123456789 |
  | pedro.pablo@gmail.com                | holamundo123       |
