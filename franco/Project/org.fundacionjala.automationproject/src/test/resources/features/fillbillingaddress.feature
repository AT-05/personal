@FillBillingAddress
Feature: FillBillingAddress
  Test successfully filling of billing address form

  @SmokeTest
  Scenario Outline: Fill billing address from
    When I fill billing address info with address "<Address>", city "<City>", state "<State>", postal code "<P-code>" and country "<Country>"
    Then I should see the billing address form filled

    Examples:
      | Address | City      | State | P-code | Country       |
      | Street1 | San Diego | CA    | 22434  | UNITED STATES |