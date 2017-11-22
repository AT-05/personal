@FillDeliveryAddress
Feature: FillDeliveryAddress
  Test successfully filling of delivery address form

  @SmokeTest
  Scenario: Fill billing address from
    When I fill delivery address info
    Then I should see the delivery address form filled
