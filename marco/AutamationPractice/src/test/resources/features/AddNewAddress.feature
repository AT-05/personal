Feature: Add NewAddress
  Given I go to login page
    And  I logIn with email  and password
  @address
  Scenario: Add a new Address to your Address list.
    When I go to Add new Address page option
      And I add new Address with the following fields
      | firstName   | Marticus         |
      | lastName    | lopez            |
      | company     | MonkeySoft       |
      | address     | B/tierras nuevas |
      | city        | santa cruz       |
      | state       | 3                |
      | postal      | 00000            |
      | country     | 21               |
      | phoneHome   | 77884632         |
      | phoneMobile | 72282814         |
      | alias       | My pato2         |
    Then should be displayed My Address page

