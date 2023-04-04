
@searchProduct
Feature: Search product functionality

Background:    Given Customer is on the Webstaurant home page

  Scenario: Customer should be able to search for specific product and add last product to cart
    Given Customer is on Webstaurant home page
    And Customer enters <"stainless steel table"> into search box
    And Customer clicks on <"search"> button
    And Customer should verify that all found products contain the word <"Table">
    Then Customer should be able to add last found product to cart
