@test
Feature: test search functionality

  Scenario:
    Given User navigate to the url
    Then User Assert that he has landed on the main page
    When User navigate to "Smart Phones" section
    And User search in "Apple" section for "iPhone 13 Pro Max"
    Then User validate result obtained