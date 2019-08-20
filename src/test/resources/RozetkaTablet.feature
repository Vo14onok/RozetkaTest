Feature: Add tablet to kart

  Background:
    Given

  @FirstTest
  Scenario:
    Given I open chrome and go to rozetka.com.ua
#    Then change city by tipyng in serch field to "Черноморск"
    Then Select "Ukranian" language
    Then I using search field search "tablet"
#    Then click tablet on side menu
    Then click on all tablets
    Then sort by newest
    Then select product owners
      | LG |
      | Samsung |
    Then select first result and add to cart
    Then go to cart

