Feature: Testing Task Builder from file
  TaskBuilderFileAdapter should load tasks from given file

  Scenario: Valid file
    Given TaskBuilderFileAdapter
    When call load tasks for 'input/input-1.txt'
    Then tasks should have '1' task

  Scenario: File without orders
    Given TaskBuilderFileAdapter
    When call load tasks for 'input/input-2.txt'
    Then tasks should have '0' task

  Scenario: Empty file
    Given TaskBuilderFileAdapter
    When call load tasks for 'input/input-2.txt'
    Then tasks should have '0' task