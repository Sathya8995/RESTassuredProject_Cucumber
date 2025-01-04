Feature: Insert products using POST API

  Scenario Outline: Validate post product api works correctly
    Given I hit the url of the post product api endpoint
    And I pass the request body of the product title <ProductTitle>
    When I pass the post url of products in the request
    Then I receive the response code as 200 and id as "21"
   Examples:
    | ProductTitle |
    | "Shoes"      |
