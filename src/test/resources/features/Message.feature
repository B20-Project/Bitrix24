@messageTab
Feature: send custom message
  As a user i want to send customized message

  Background: login
    Given user is on the home page
    And user clicks menu "Activity Stream"
    And user clicks "Message" tab under Activity Stream

  @US1AC5
  Scenario: Users should be able to create a quote by clicking on the Comma icon.
    Given user is on the home page
    When user click "message"
    And user click "quote text" icon
    Then user should able to enter the quote

  @US1AC6
  Scenario: Users should be able to create a quote by clicking on the Comma icon.
    Given user is on the home page
    When user click "message"
    And user click "Add mention" icon
    Then user should able to mention contacts from giving list;

  @uploadFromLocal
  Scenario: upload single file from local disk
    When user clicks on post button "Upload files"
    And  user uploads local file "C:/Users/Aji/Desktop/CRM24/old11file.txt"
    Then "old11file.txt" should display under attached files

  @uploadFromRemoteCompanyDrive
  Scenario: upload single file from remote drive
    When user clicks on post button "Upload files"
    And user clicks bitrix24 remote drive
    And user uploads "Quote.docx" file from company drive
    Then "Quote.docx" should display under attached files

  @addContact
  Scenario: add employee from Employees and departments tab
    And  user adds employee "helpdesk23@cybertekschool.com" from contacts "Recent" tab
    Then employee "helpdesk23@cybertekschool.com" should appear in the destination box

  @getEditorTextBar
  Scenario: get visual editor text bar
    And user clicks on "Visual editor" icon
    Then user should be able to see the editor text-bar displays on top message box
