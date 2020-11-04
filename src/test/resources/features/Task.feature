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

  @RepeatByDay1
  Scenario: Repeat task by bay
    When user click on More
    And user click "Repeat task" check box
    Then user select "day"
    And enter every 1 "any" day with an interval of 0 mo.

  @RepeatByMonth1
  Scenario: Repeat task by month
    When user click on More
    And user click "Repeat task" check box
    Then user select "month"
    And select evert and enter 1 day of every 1 month

  @RepeatByMonth2
  Scenario: Repeat task by month
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

  @RepeatByWeek1
  Scenario: Repeat task by week
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

  @RepeatByYear1
  Scenario: Repeat task by year
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

  @RepeatByYear2
  Scenario: Repeat task by year
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

  @RepeatUntilNoEndDay
  Scenario: Repeat task until no end date
    When user click on More
    And user click "Repeat task" check box
    Then verify that "no end date" is selected

  @RepeatUntilEndDay @bug
  Scenario: Repeat task until end date
    When user click on More
    And user click "Repeat task" check box
    Then select "end date" under repeat until
    And click on date enter under repeat until
    Then Select "10-12-2020" as date


  @RepeatUntilCompleteAfterDay
  Scenario: Repeat task until complete after date
    When user click on More
    Then user click "Repeat task" check box
    And select "complete after" under repeat until
    Then enter 5 as iterations

  @SubtaskTasks
  Scenario: assigned Subtask tasks
    When user click on More
    And click +Add on "Subtask of"
    Then select "test [2336]" from recent tasks;
    Then click SELECT in Subtask popup

  @Tags
  Scenario: create Tags
    When user click on More
    And click +Add on "Tags"
    Then select "group28" from Tags popUp;
    Then click SAVE in Tags popUp

  @DependentTasks
  Scenario: assigned Dependent tasks
    When user click on More
    And click +Add on "Dependent tasks"
    Then select "test [2336]" from Dependent tasks popUp;
    Then click SELECT in Dependent tasks popUp

  @selectMultiplePeople
    Scenario: select multiple people
      And user clicks on "Add more" button in "Responsible person" block
      And user selects following from "Employees and departments"
       | helpdesk22@cybertekschool.com |
       | helpdesk23@cybertekschool.com |
       | helpdesk24@cybertekschool.com |
      When user clicks on task additional block "Participants"
      And user clicks on "Add" button in "Participant" block
      And user selects following from "Employees and departments"
        | helpdesk25@cybertekschool.com |
        | helpdesk26@cybertekschool.com |
        | helpdesk27@cybertekschool.com |
      When user clicks on task additional block "Observers"
      And user clicks on "Add" button in "Observers" block
      And user selects following from "Employees and departments"
        | helpdesk28@cybertekschool.com |
        | helpdesk29@cybertekschool.com |
        | helpdesk30@cybertekschool.com |
      And user clicks on "Send" button
      Then "Task has been created" message should display in pop-up window

  @end_to_end
  Scenario: end to end testing
    #selectPeople
    And user selects  responsible person "helpdesk22@cybertekschool.com" from "Employees and departments"
    And user clicks on task additional block "Created by"
    When user clicks on task additional block "Participants"
    And user clicks on "Add" button in "Participant" block
    And user selects "helpdesk23@cybertekschool.com" from "Employees and departments"
    When user clicks on task additional block "Observers"
    And user clicks on "Add" button in "Observers" block
    And user selects "helpdesk24@cybertekschool.com" from "Employees and departments"

    #calendar
    When user clicks on Deadline input box under task
      #mm-dd-yyyy format
    And Select "6-13-2020" as date
    And Select "8-00-am" as time
    And user clicks on select button in calendar

    #timePlanning
    When user click on "time planning" next to Deadline
    And user click on "Start task on" under time planning
    And Select "10-12-2020" as date
    And Select "06-00-am" as time
    And user clicks on select button in calendar
    Then user click on "duration" under time planning
    And user enter "10" as duration
    When user select "minutes" under duration

    #options
    When user click on "options" next to Deadline
    Then user should be able to select all available checkboxes

    #timeTracking
    When user click on More
    And user select Task planned time checkbox
    Then enter "5" in hour and "12" minutes

    #reminder
    When user click on Add reminder
    And user click on date input box
    And Select "07-11-2020" as date
    And Select "06-00-am" as time
    And user clicks on select button in calendar
    Then select any role under reminder
    And user clicks on "message" icon in reminder
    And user clicks on Add in reminder

    #RepeatByDay1
    And user click "Repeat task" check box
    Then user select "day"
    And enter every 1 "any" day with an interval of 0 mo.

     #RepeatByWeek1
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

    #RepeatByMonth1
    Then user select "month"
    And select evert and enter 1 day of every 1 month

    #RepeatByMonth2
    And select evert and select "first" "Thursday"

    #RepeatByYear1
    Then user select "year"
    And enter 1 day "December" on first every under year

    #RepeatByYear2
    And select second every under year
    And select "last" "Wednesday" month "August" under year

    #RepeatUntilNoEndDay
    Then verify that "no end date" is selected

    #RepeatUntilEndDay
    Then select "end date" under repeat until
    And click on date enter under repeat until
    Then Select "10-12-2020" as date

    #RepeatUntilCompleteAfterDay
    And select "complete after" under repeat until
    Then enter 5 as iterations

    #SubtaskTasks
#    And click +Add on "Subtask of"
#    Then select "test [2404]" from recent tasks;
#    Then click SELECT in Subtask popup

    #Tags
    And click +Add on "Tags"
    Then select "group28" from Tags popUp;
    Then click SAVE in Tags popUp

    #DependentTasks
#    And click +Add on "Dependent tasks"
#    Then select "test [2432]" from Dependent tasks popUp;
#    Then click SELECT in Dependent tasks popUp

#    And user clicks on "Send" button
