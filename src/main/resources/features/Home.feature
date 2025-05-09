Feature: Home

  @Home @UITest @Test_001 @Regression
  Scenario: Validate elements on home screen
    Given that the YouTube App was open
    When I allow youtube to send notifications
    Then validate elements on the home screen

