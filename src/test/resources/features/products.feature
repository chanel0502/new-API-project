Feature: Product and Services

  Scenario: Verify every product or service type of service and category fields
    Given user hits get all products api with "/api/myaccount/products" params page 1 and size 10
    Then user verifies all the products service type and categories

  @product
  Scenario: Verify service types
      Given user hits get all products api with "/api/myaccount/products" params page 1 and size 10
      Then user verifies service types has value "Service" or "Product"

