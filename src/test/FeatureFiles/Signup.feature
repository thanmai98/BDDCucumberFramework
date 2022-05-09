Feature: Registration for PHPTravels site

  @test
  Scenario Outline: User should be able to register for PHPTravels site

    Given User launches required "<Browser>"
    Then User should navigate to PHPTravels site
    And User clicks on signup button

    Examples:
      | Browser |
      | Chrome  |