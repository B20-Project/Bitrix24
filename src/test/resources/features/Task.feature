@createTask
Feature: create task
  As a user I want to create customized task

  Background: login
    Given user is on the home page
    And user clicks menu "Activity Stream"
    And user clicks "Task" tab under Activity Stream
    And user enters title on "Things to do" input box and enters "Create task"

  @AC1
  Scenario: create a simple task with repeat day
    When user click "More"
    And user click "Repeat task" check box
    Then user select "day"
    And enter every 1 "any" day with an interval of 0 mo.

  @AC2
  Scenario: create a simple task with repeat week
    When user click "More"
    And user click "Repeat task" check box
    Then user select "week"
    And enter every 1 week
    And select following day
      | Sun |
      | Mo  |
      | Tu  |
      | We  |
      | Thu |
      | Fri |
      | Sat |
    And verify following day is selected
      | Sun |
      | Mo  |
      | Tu  |
      | We  |
      | Thu |
      | Fri |
      | Sat |


