Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Checkout Experience for product search in both home and Offers page

Given user is on GreenCart Landing page
When  user searched with shortname <Name> and extracted actual name of the product
And   added <Quantity> items of the selected product to cart
Then  user proceeds to checkout and validate the <Name> items in checkout page
And   verify user has ability to enter promo code and place the order

Examples:
| Name | Quantity |
| Tom  |    3			|



