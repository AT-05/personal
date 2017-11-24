@SearchFlight
Feature: Search Flight
  Test successfully searching of flight

  Background:
    Given I am logged in the application

  @SmokeTest
  Scenario Outline: Verify that is possible to search a flight
    When I search a flight with "<Flight-type>", "<Passengers>" passenger, from "<Origin>", on "<Departure-Month>" "<Departure-Day>", to "<Destination>" on "<Return-Month>", "<Return-Day>" in "<Class>" class and "<Airline>"
    Then I should have a result list of "<Origin>" to "<Destination>" flights

    Examples:
      | Flight-type | Passengers | Origin | Departure-Month | Departure-Day | Destination | Return-Month | Return-Day | Class    | Airline             |
      | oneway      | 2          | London | December        | 14            | New York    | February     | 10         | Business | Blue Skies Airlines |