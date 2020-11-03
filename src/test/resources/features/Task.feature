@createTask
Feature: create task
  As a user I want to create customized task

  Background: login
    Given user is on the home page
    And user clicks menu "Activity Stream"
    And user clicks "Task" tab under Activity Stream
    And user enters title on "Things to do" input box and enters "Create a task"
    And user enters description "Toronto"

  @selectPeople
  Scenario: select people
    And user selects  responsible person "helpdesk22@cybertekschool.com" from "Employees and departments"
    And user clicks on task additional block "Created by"
    When user clicks on task additional block "Participants"
    And user clicks on "Add" button in "Participant" block
    And user selects "helpdesk23@cybertekschool.com" from "Employees and departments"
    When user clicks on task additional block "Observers"
    And user clicks on "Add" button in "Observers" block
    And user selects "helpdesk24@cybertekschool.com" from "Employees and departments"
    And user clicks on "Send" button
    Then "Task has been created" message should display in pop-up window

  @taskArpatAC
  Scenario: create a simple task with repeat day
    When user click "More"
    And user click "Repeat task" check box
    Then user select "day"
    And enter every 1 "any" day with an interval of 0 mo.

  @taskArpatAC
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

  @taskArpatAC
  Scenario: create a simple task with repeat week
    When user click "More"
    And user click "Repeat task" check box
    Then user select "month"
    And select evert and enter 1 day of every 1 month

  @taskArpatAC
  Scenario: create a simple task with repeat week
    When user click "More"
    And user click "Repeat task" check box
    Then user select "month"
    Then verify following type is in first selector under month
      | first  |
      | second |
      | third  |
      | fourth |
      | last   |
    Then verify following type is in second selector under month
      | Sunday    |
      | Monday    |
      | Tuesday   |
      | Wednesday |
      | Thursday  |
      | Friday    |
      | Saturday  |
    And select evert and select "first" "Monday"

  @taskArpatAC
  Scenario: create a simple task with repeat week
    When user click "More"
    And user click "Repeat task" check box
    Then user select "year"
    Then verify following type is in first selector under year
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |
    And enter 1 day "December" on first every under year

  @taskArpatAC
  Scenario: create a simple task with repeat week
    When user click "More"
    And user click "Repeat task" check box
    Then user select "year"
    And select second every under year
    Then verify following day type of day in second selector under year
      | first  |
      | second |
      | third  |
      | fourth |
      | last   |
    Then verify following week type of week in second selector under year
      | Sunday    |
      | Monday    |
      | Tuesday   |
      | Wednesday |
      | Thursday  |
      | Friday    |
      | Saturday  |
    Then verify following month type of month in second selector under year
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |
    And select "last" "Wednesday" month "August" under year
