Feature: Open Cart Feature


Scenario: Place an order
Given User is on Home Page
When User search "Phone"
And User add Item to cart
Then Item must be added to cart 
