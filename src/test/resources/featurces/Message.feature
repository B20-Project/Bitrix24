@messageTab
Feature: send custom message
  As a user i want to send customized message

  Background: login
    Given user is on the home page
    When user clicks menu "Activity Stream"
    And user click "Message" module

  @getEditorTextBar
  Scenario: get visual editor text bar
    And user clicks on "Visual editor" icon
    Then user should be able to see the editor text-bar displays on top message box
