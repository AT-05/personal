Feature: createNewAccount

  Background:

  Scenario Outline: this scenario create a new account for each email validate
    Given I navigate to MainPage and push new email"<email>"
    When I create a new Account with the following personal information "<firstName>","<lastName>","<email>","<password>" and also "<day>","<month>","<year>"
    And also with the following address information "<nameAddress>","<lastAddress>","<company>","<address>" and also "<city>","<state>","<postalCode>","<country>","<phone>"
    Then should be displayed Home page

    Examples:
      | firstName   | lastName       | email                    | password     | day | month | year |nameAddress  | lastAddress     |  company    |  address  | city       | state | postalCode | country |  phone  |
      | Pedro Pablo | Leon Jaramillo | pedro.pablo2@gmail.com   | holamundo123 | 15  | 5     | 1900 | My House    |  en santa cruz  |  MonkeySoft | av.moscu  | Santa cruz | 3     | 00000      | 21      |77884632 |
      | Franco      | alvarez        | Franco.alvarez2@gmail.com| holamundo123 | 15  | 5     | 1900 | My House    |  en santa cruz  |  MonkeySoft | av.moscu  | Santa cruz | 3     | 00000      | 21      |77884632 |
      | Oscar       | lejeron        | Oscar.lejeron2@gmail.com | holamundo123 | 15  | 5     | 1900 | My House    |  en santa cruz  |  MonkeySoft | av.moscu  | Santa cruz | 3     | 00000      | 21      |77884632 |

