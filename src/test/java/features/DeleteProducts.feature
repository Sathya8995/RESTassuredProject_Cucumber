Feature: Delete products using DELETE API

  Scenario Outline: Validate delete product api works correctly
    Given I hit the url of the api endpoint
    When I pass the delete url of products in the request <endpoint>
    Then I receive the response code as <StatusCode> and id as <endpoint>
    Examples:
      | endpoint | StatusCode |
      | "5"      | 200        |