Feature: Emicalculator

  Scenario: Car Loan
    Given User fetch the car loan title
    When User verifies the title
    Then User clicks on Car Loan button
    And User changes values using slider
    And User fetch the principal and interest for advance and arrears
