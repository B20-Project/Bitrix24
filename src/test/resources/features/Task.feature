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






