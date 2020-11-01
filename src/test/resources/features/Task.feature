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
    And enter every 1 select day type and with an interval of 0 mo.


