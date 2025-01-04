Feature: Insert products using POST API

  Scenario Outline: Validate post product api works correctly
    Given I hit the url of the api endpoint
    And I pass the request body of the product title <ProductTitle>
    When I pass the post url of products in the request
    Then I receive the response code as <StatusCode> and id as <id>
   Examples:
    | ProductTitle | StatusCode | id   |
    | "Shoes"      | 200        | "21" |
