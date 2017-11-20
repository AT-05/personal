@SearchFlight
Feature: SearchFlight
  Test successfully searching of flight

  Background:
    Given I navigate to Main Page
    And I login as "faldunate" with password "password1"

  @SmokeTest
  Scenario Outline: Search a flight
    When I select the type of flight as "<Flight-type>"
    And I choose flight for "<Passengers>" passengers
    And I choose as origin location "<Origin>"
    And I select as departure date "<Departure-Month>", "<Departure-Day>"
    And I select destination as "<Destination>"
    And I select as return date "<Return-Month>", "<Return-Day>"
    And I choose "<Class>" as service class
    And I select airline "<Airline>"
    Then I should have a result list of "<Origin>" to "<Destination>" flights

    Examples:
      | Flight-type | Passengers | Origin | Departure-Month | Departure-Day | Destination | Return-Month | Return-Day | Class    | Airline             |
      | oneway      | 2          | London | December        | 14            | New York    | February     | 10         | Business | Blue Skies Airlines |