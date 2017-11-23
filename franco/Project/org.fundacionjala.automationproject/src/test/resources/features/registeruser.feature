@RegisterUser
Feature: Register User
  Test successfully registration of user

  Background:
    Given I navigate to Main Page

  @SmokeTest
  Scenario: Verify that is possible to register a user in the application
    Given I select Registration option in Menu
    When I fill user info with

      | firstName | lastName | phone    | email                  | address   | city       | state   | zip   | country | userName | password  |
      | Roberto   | Fuentes  | 54332154 | robfuentes@hotmail.com | Street277 | Cochabamba | Cercado | 65362 | BOLIVIA | rfuentes | password3 |

    Then I should see a user registered confirmation message