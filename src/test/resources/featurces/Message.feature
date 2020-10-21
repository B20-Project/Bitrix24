Feature: As a user, I should be able to send messages by clicking on the Message tab under Active Stream.

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