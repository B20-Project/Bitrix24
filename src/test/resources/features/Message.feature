@messageTab
Feature: send custom message
  As a user i want to send customized message

  Background: login
    Given user is on the home page
    And user clicks menu "Activity Stream"
    And user clicks "Message" tab under Activity Stream

  @uploadFromLocal @bug
  Scenario: upload single file from local disk
    When user clicks on post button "Upload files"
    And  user uploads local file "C:/Users/Aji/Desktop/CRM24/old11file.txt"
    Then "old11file.txt" should display under attached files

  @enterQuote @AC5
  Scenario: Users should be able to create a quote by clicking on the Quote text icon.
    And user clicks on post button "Quote text"
    Then user should able to enter the quote

  @addMention @AC6
  Scenario: Users should be able to mention people by clicking on the Add mention icon.
    And user clicks on post button "Add mention"
    Then user should able to mention contacts from giving list;

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

  @getEditorTextBar @AC7
  Scenario: get visual editor text bar
    And user clicks on post button "Visual editor"
    Then user should be able to see the editor text-bar displays on top message box

  @creatingLink @AC3
  Scenario: create link using link icon
    When user clicks on post button "Link"
    And the user click on Text to enter "sample link text"
    And the user click on Link to enter "sample Link Url"
    And click on link save button
    Then new link should be created displaying "sample link text"

  @insertVideo @AC4
  Scenario: insert video using video icon
    When user clicks on post button "Insert video"
    And the user enter video url "https://www.youtube.com/watch?v=-FlxM_0S2lA"
    And click on save button
    Then new video link should be created on the text box

  @getTopicInputBox @AC8
  Scenario: topic input box
    When user clicks on post button "Topic"
    Then Topic input box should display

  @recordVideo @AC9
  Scenario: record video
    When user clicks on icon "Record Video"
    Then user should be able to see message in pop-up window


