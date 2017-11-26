@FlightReservation
Feature: Flight Reservation
  Test successfully reservation of flight

  Background:
    Given I am logged in the application

  @SmokeTest
  Scenario Outline: Verify that is possible to purchase a flight ticket
    Given I search a flight with "oneway", "1" passenger, from "London", on "December" "14", to "New York" on "February", "10" in "Business" class and "Blue Skies Airlines"
    When I select departure and return flight as "<Departure-flight>", "<Return-flight>"
    And I fill the passengers' information with name "<FName>", last name "<LName>", and meal "<Meal>"
    And I fill the credit card info with type "<Card-type>", number "<Credit-Card>", first name "<COFName>", middle name "<COMName>" and last name "<COLName>"
    And I fill billing address with the following information
      | address | city      | state | zip   | country       |
      | Street1 | San Diego | CA    | 22434 | UNITED STATES |
    And I fill delivery address info
    Then I should have a flight confirmation document with total price "<Total-price>"

    Examples:
      | Departure-flight | Return-flight | FName  | LName    | Meal        | Card-type | Credit-Card      | COFName | COMName  | COLName | Total-price |
      | 1                | 1             | Franco | Aldunate | Low Calorie | Visa      | 4539021054099252 | Raul    | Aldunate | Cordero | $588 USD    |