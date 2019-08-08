Feature: Compare air conditioning

  @NewTest
  Scenario: Go to rozetka.com and compare air conditioning

    Given I open chrome and go to rozetka.com.ua
    Then select any city
    Then I using search field search "кондиционер"
    Then select 6 first results
    Then compare results