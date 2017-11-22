@AddNewAddress
Feature: AddNewAddress

  Scenario Outline: Add a new Address to your Address list.
    Given I navigate to login page
    And  I logIn with email "<Email_user>" and password "<Password>"
    When I go to Add new Address page
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
      | alias       | My office3       |

    Then should be displayed My Address page


    Examples:
      | Email_user              | Password     |
      | pedro.pablo17@gmail.com | holamundo123 |
