@createTask
Feature: create task
  As a user I want to create customized task

  Background: login
    Given user is on the home page
    And user clicks menu "Activity Stream"
    And user clicks "Task" tab under Activity Stream
    And user enters title on "Things to do" input box and enters "Create task"
    And user enters description "Task Description"

    @calendar
  Scenario: selecting date and time in calendar
    When user clicks on Deadline input box under task
      #mm-dd-yyyy format
    And Select "5-20-2020" as date
    And Select "10-30-am" as time
    And user clicks on select button in calendar
    Then "11/01/2020 05:59 am" should be displayed in the Deadline input box

  Scenario: verify Time planning
    When user click on "Time Planning" next to Deadline
    And user click on "Start task on" under time planning
    And Select "10-12-2020" as date
    And Select "06-00-am" as time
    And Then click on select button in calendar
    Then user click on "Duration" under time planning
    And user enter "10" as duration
    When user select "days" under duration
    Then "11/15/2020 05:00 am" should be displayed on finish input box

  Scenario: verify options
    When user click on "Options" next to Deadline
    Then user should be able to select any of the "2" available checkboxes
    When Derive task dates from subtask dates option is selected
    Then Skip Weekends and holidays option should be un-selected

  Scenario: verify time tracking
    When user click on More
    And user select Task planned time checkbox
    Then enter "05" in hour and "12" minutes

  Scenario: verify reminder
    When user click on Add reminder
    And Select "07-11-2020" as date
    And Select "06-00-am" as time
    Then click on select button in reminder
    Then select any role under reminder
    And user clicks on "email" icon in reminder
    And user clicks on Add in reminder
    Then new reminder tab should be displayed above Add reminder









