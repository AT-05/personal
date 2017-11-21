@Login
Feature: loginUser

  Scenario : this scenario verify the  users login
    Given I navigate to login page
   # When I fill the field email "<Email_user>" and password "<Password>"
     When I fill the field email  and password
    Then should be displayed My Account page

