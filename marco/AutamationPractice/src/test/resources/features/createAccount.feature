Feature: createNewAccount
  @CreateAccount
  Scenario Outline: Verify the creation of new accounts
    Given I go to login page
      And I authenticate new email"<email>"
    When I create a new Account with the following personal information "<firstName>","<lastName>","<email>","<password>" and also "<day>","<month>","<mark>"
      And also with the following address information "<nameAddress>","<lastAddress>","<company>","<address>" and also "<city>","<state>","<postalCode>","<country>","<phone>"
    Then should be displayed Home page
    Examples:
      | firstName   | lastName       | email                     | password     | day | month | mark | nameAddress | lastAddress   | company    | address  | city       | state | postalCode | country | phone    |
      | Pedro Pablo | Leon Jaramillo | pedro.pablo18@gmail.com   | holamundo123 | 15  | 5     | 1900 | My House    | en santa cruz | MonkeySoft | av.moscu | Santa cruz | 3     | 00000      | 21      | 77884632 |
      | Pablo       | Escobar        | pablo.escobar18@gmail.com | holamundo123 | 15  | 5     | 1900 | My House    | en santa cruz | MonkeySoft | av.moscu | Santa cruz | 3     | 00000      | 21      | 77884632 |
      | Chapo       | Guzman         | Chapo.Chapo18@gmail.com   | holamundo123 | 15  | 5     | 1900 | My House    | en santa cruz | MonkeySoft | av.moscu | Santa cruz | 3     | 00000      | 21      | 77884632 |

