
@emptyCart
Feature: Webstaurant cart functionality

  Scenario: Customer should be able to empty cart
 Given Customer is on Webstaurant home page
    And Customer enters <"stainless steel table"> into search box
    And Customer clicks on <"search"> button
    And Customer should verify that all found products contain the word <"Table">
    Then Customer should be able to add last found product to cart
    And Customer verifies he lands on cart page
    Then Customer clicks on the <"empty cart"> button
    Then Customer confirms and clicks on <"confirm empty cart"> button