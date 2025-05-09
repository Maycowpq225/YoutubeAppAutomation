Feature: VideoSearching


  @VideoSearching @E2E @Test_002 @Regression
  Scenario: Search for a video
    Given that the YouTube App is open and ready to use
    When I click on the search field on homeScreen
    And search on the field for the word "Games"
    Then the first result must contain the word "Games" on the title

  @VideoSearching @E2E @Test_003 @Regression
  Scenario: Validate tab "Shorts" just have short videos
    Given that the YouTube App is open and ready to use
    When I click on the search field on homeScreen
    And search on the field for the word "Games"
    And click on the filter "Shorts"
    Then just the filter "Shorts" should appear on the screen

  @VideoSearching @E2E @Test_004 @Regression
  Scenario: Validate tab "Videos" just have videos
    Given that the YouTube App is open and ready to use
    When I click on the search field on homeScreen
    And search on the field for the word "Games"
    And click on the filter "Videos"
    Then just the filter "Videos" should appear on the screen