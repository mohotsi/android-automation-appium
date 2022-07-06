Feature: Order
  Scenario: test 1
    When User Navigate to Shop
    And User Navigate to Ladies
    And User Navigate to Shop clothing
    And User Navigate to shopping category "Dresses / Tunics"
    And Sort by "Price: Low to High"
    Then The products are sorted By Price "Price: Low to High"
