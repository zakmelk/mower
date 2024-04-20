Feature: Testing Order Enum
  Order Enum should be created from a valid character

  Scenario: Valid character
    Given toto
    When call OrderEnum.fromChar with character 'A'
    Then fromChar should return OrderEnum.A