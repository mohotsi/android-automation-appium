Feature: Order
  Scenario: Order a dress
    When User Navigate to Shop
    Then User Navigate to Ladies
    Then User Navigate to Shop clothing
    Then User Navigate to shopping category "Dresses / Tunics"
    Then Select product item by name "Maxi Dress"
