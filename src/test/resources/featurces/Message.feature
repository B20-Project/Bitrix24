Feature: User should be able to attach link by clicking on the link icon.
  Background: common steps
    Given the user logged in and located in basepage

  Scenario: creating link
    When the user click on the link tab
    And the user click on Text to enter "sample link text"
    And the user click on Link to enter "sample Link Url"
    And click on save button
    Then new link should be created on the text box

