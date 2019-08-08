Feature: Compare air conditioning

  @Broken
  Scenario: Go to rozetka.com and compare air conditioning

    Given I open chrome and go to rozetka.com.ua
    Then select any city
    Then I using search field search "кондиционер"
    Then select producer "Boch", "LG" and "Samsung"
#    Then sort by popularity
    Then select 3 first results
    Then compare results
    Then take screenshot