Feature: Search and Place the order for Products


@searchItems
Scenario Outline: Search Experience for product search in both home and Offers page

Given user is on GreenCart Landing page
When user searched with shortname <Name> and extracted actual name of the product
Then user searched for the <Name> shortname in offers page
And  validate product name in offers page matches with landing page


Examples:

|Name|						
|Tom|
|Beet|



