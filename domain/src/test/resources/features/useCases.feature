Feature: Testing Mower service
  Service should return the final mower's state after executing orders

  Scenario: case 1
    Given input '5 5 1 2 N GAGAGAGAA'
    When call task launch order
    Then output should be '1 3 N'

  Scenario: case 2
    Given input '5 5 3 3 E AADAADADDA'
    When call task launch order
    Then output should be '5 1 E'

  Scenario: case 3
    Given input '5 5 3 3 W AAAAGAAAAA'
    When call task launch order
    Then output should be '0 0 S'