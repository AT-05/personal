@RegisterUser
Feature: RegisterUser
  Test successfully registration of user

  Background:
    Given I navigate to Main Page

  @SmokeTest
  Scenario: Register a user in the web page
    Given I navigate to Registration Page
    When I fill user info with

      | FirstName | Roberto                |
      | LastName  | Fuentes                |
      | Phone     | 54332154               |
      | Email     | robfuentes@hotmail.com |
      | Address   | Street277              |
      | City      | Cochabamba             |
      | State     | Cercado                |
      | Zip       | 65362                  |
      | Country   | BOLIVIA                |
      | Username  | rfuentes               |
      | Password  | password3              |

    Then I should see a user registered confirmation message

