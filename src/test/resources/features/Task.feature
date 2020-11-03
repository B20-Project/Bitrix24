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
    And Select "6-13-2020" as date
    And Select "8-00-am" as time
    And user clicks on select button in calendar
    Then "11/01/2020 05:59 am" should be displayed in the Deadline input box

  @timePlanning
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

  @options
  Scenario: verify options
    When user click on "options" next to Deadline
    Then user should be able to select all available checkboxes

  @timeTracking
  Scenario: verify time tracking
    When user click on More
    And user select Task planned time checkbox
    Then enter "5" in hour and "12" minutes

  @reminder
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









