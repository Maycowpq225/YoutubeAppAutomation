Feature: VideoSearching


  @VideoSearching @E2E
  Scenario: Search for a video
    Given that the YouTube App is open and ready to use
    When I click on the search field on homeScreen
    And search on the field for the word "Games"
    Then The first result must contains the word "Games" on the title