Feature: Compare air conditioning

  Scenario: Go to rozetka.com and compare air conditioning

    Given I open chrome and go to rozetka.com.ua
    Then select any city
    When I using search field search "кондиционер"
    Then select 2 first results
    Then compare results