@createTask
Feature: As a user I want to create customized task

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

  @calendar
  Scenario: selecting date and time in calendar
    When user clicks on Deadline input box under task
      #mm-dd-yyyy format
    And Select "6-13-2020" as date
    And Select "8-00-am" as time
    And user clicks on select button in calendar
    Then "11/01/2020 05:59 am" should be displayed in the Deadline input box

  @timePlanning   @calendar
  Scenario: verify Time planning
    When user click on "time planning" next to Deadline
    And user click on "Start task on" under time planning
    And Select "10-12-2020" as date
    And Select "06-00-am" as time
    And user clicks on select button in calendar
    Then user click on "duration" under time planning
    And user enter "10" as duration
    When user select "minutes" under duration
    Then "11/15/2020 05:00 am" should be displayed on finish input box

  @options   @calendar
  Scenario: verify options
    When user click on "options" next to Deadline
    Then user should be able to select all available checkboxes

  @timeTracking   @calendar
  Scenario: verify time tracking
    When user click on More
    And user select Task planned time checkbox
    Then enter "5" in hour and "12" minutes

  @reminder   @calendar
  Scenario: verify reminder
    When user click on More
    When user click on Add reminder
    And user click on date input box
    And Select "07-11-2020" as date
    And Select "06-00-am" as time
    And user clicks on select button in calendar
    Then select any role under reminder
    And user clicks on "message" icon in reminder
    And user clicks on Add in reminder
    Then new reminder tab should be displayed above Add reminder

  @taskArpatAC1
  Scenario: create a simple task with repeat day
    When user click on More
    And user click "Repeat task" check box
    Then user select "day"
    And enter every 1 "any" day with an interval of 0 mo.

  @taskArpatAC1
  Scenario: create a simple task with repeat week
    When user click on More
    And user click "Repeat task" check box
    Then user select "month"
    And select evert and enter 1 day of every 1 month

  @taskArpatAC1
  Scenario: create a simple task with repeat week
    When user click on More
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

  @taskArpatAC1
  Scenario: create a simple task with repeat week
    When user click on More
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
    And select evert and select "first" "Thursday"

  @taskArpatAC1
  Scenario: create a simple task with repeat week
    When user click on More
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

  @taskArpatAC1
  Scenario: create a simple task with repeat week
    When user click on More
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

  @taskArpatAC1
  Scenario: create a simple task with repeat week
    When user click on More
    And user click "Repeat task" check box
    Then verify that "no end date" is selected

  @taskArpatAC1 @bug
  Scenario: create a simple task with repeat week
    When user click on More
    And user click "Repeat task" check box
    Then select "end date" under repeat until
    And click on date enter under repeat until
    #Then Select "10-12-2020" as date

  @taskArpatAC11
  Scenario: create a simple task with repeat week
    When user click on More
    Then user click "Repeat task" check box
    And select "complete after" under repeat until
    Then enter 5 as iterations


