#Author: thuong.lambale@gmail.com
#Background: No login (used as guest)
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@development
Feature: Order items on Amazon

  @development
  Scenario Outline: Normal order flow
    Given I am on Amazon Homepage
    # first order
    When Go to Today’s Deal
    And Sort the items by “Discount: High to Low”
    And View Deal for second item
    And Add <firstCount> first items into the cart
    Then Check first order: quantities, individual prices, combined prices
    # second order
    When Go back to main page
    And Search for <searchKey>
    And Sort the items by “Newest Arrivals”
    And Add <secondCount> second items into the cart
    Then Check second order: quantities, individual prices, combined prices
    # third order
    When Go to your cart
    And Edit the first item quantity - set to <firstCountAfter>
    And Edit the second item quantity – set to <secondCountAfter>
    And Delete the first item
    Then Check third order: quantities, individual prices, combined prices
    # checkout
    When Click “Proceed to Checkout”
    Then I am on Login page

    Examples: 
      | firstCount | searchKey     | secondCount | firstCountAfter | secondCountAfter |
      |          2 | AAA Batteries |           5 |               1 |                3 |
      |          1 | Books         |           2 |               2 |                4 |
