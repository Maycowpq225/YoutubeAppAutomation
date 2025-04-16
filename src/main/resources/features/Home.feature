Feature: Home

  @Home @UITest @Test_001
  Scenario: Validate elements on home screen
    Given that the YouTube App was open
    When I allow youtube to send notifications
    And accept all the cookies
    Then validate elements on the home screen

