Feature: Compare air conditioning

  @SmokeTest
  Scenario: Go to rozetka.com and compare air conditioning

    Given I open chrome and go to rozetka.com.ua
    Then select any city
    Then I using search field search "кондиционер"
    Then select 3 first results
    Then compare results