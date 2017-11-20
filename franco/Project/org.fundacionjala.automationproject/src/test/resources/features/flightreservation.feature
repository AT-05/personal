@FlightReservation
Feature: FlightReservation
  Test successfully reservation of flight

  Background:
    Given I navigate to Main Page
    And I login as "faldunate" with password "password1"
    And I select the type of flight as "oneway"
    And I choose flight for "1" passengers
    And I choose as origin location "London"
    And I select as departure date "December", "14"
    And I select destination as "New York"
    And I select as return date "February", "10"
    And I choose "Business" as service class
    And I select airline "Blue Skies Airlines"

  @SmokeTest
  Scenario Outline: Purchase a flight ticket
    When I select "<Departure-flight>" as departure flight
    And I select "<Return-flight>" as return flight
    And I fill the passengers' information with name "<FName>", last name "<LName>", and meal "<Meal>"
    And I fill the credit card info with type "<Card-type>", number "<Credit-Card>", first name "<COFName>", middle name "<COMName>" and last name "<COLName>"
    And I fill billing address info with address "<Address>", city "<City>", state "<State>", postal code "<P-code>" and country "<Country>"
    And I fill delivery address with same info as billing address
    Then I should have a flight confirmation document with total price "<Total-price>"

    Examples:
      | Departure-flight | Return-flight | FName  | LName    | Meal        | Card-type | Credit-Card      | COFName | COMName  | COLName | Address | City      | State | P-code | Country       | Total-price |
      | 1                | 1             | Franco | Aldunate | Low Calorie | Visa      | 4539021054099252 | Raul    | Aldunate | Cordero | Street1 | San Diego | CA    | 22434  | UNITED STATES | $588 USD    |