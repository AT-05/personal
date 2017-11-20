@CreateAccount
Feature: createNewAccount

  Background:

  Scenario Outline: A scenario
    Given I navigate to MainPage and put new email"<email>"
    When I create a new Account with the following personal information "<firstName>","<lastName>","<email>","<password>" and also "<day>","<month>","<mark>"
    And also with the following address information "<nameAddress>","<lastAddress>","<company>","<address>" and also "<city>","<state>","<postalCode>","<country>","<phone>"
    Then should be displayed Home page

    Examples:
      | firstName   | lastName       | email                 | password     | day | month | mark |nameAddress | lastAddress     |  company    |  address  | city       | state | postalCode| country|  phone  |
      | Pedro Pablo | Leon Jaramillo | pedro.pablo16@gmail.com   | holamundo123 | 15  | 5     | 1900 | My House    | en santa cruz | MonkeySoft | av.moscu | Santa cruz | 3     | 00000      | 21      | 77884632 |
      | Pablo       | Escobar        | pablo.escobar16@gmail.com | holamundo123 | 15  | 5     | 1900 | My House    | en santa cruz | MonkeySoft | av.moscu | Santa cruz | 3     | 00000      | 21      | 77884632 |
      | Chapo       | Guzman         | Chapo.Chapo16@gmail.com   | holamundo123 | 15  | 5     | 1900 | My House    | en santa cruz | MonkeySoft | av.moscu | Santa cruz | 3     | 00000      | 21      | 77884632 |

