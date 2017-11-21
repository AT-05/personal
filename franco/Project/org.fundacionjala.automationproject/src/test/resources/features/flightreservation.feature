@FlightReservation
Feature: FlightReservation
  Test successfully reservation of flight

  Background:
    Given I navigate to Main Page
    And I log in to the application
    And I search a flight as "oneway", "1" passenger, from "London", on "December" "14", to "New York" on "February", "10" in "Business" class and "Blue Skies Airlines"

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