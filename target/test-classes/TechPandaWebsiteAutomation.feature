Feature: TechPanda Website Functionalities

  @firstScenario
  Scenario: Verify that products are sorted by name
    Given I am on the TechPanda homepage
    When I click on the Mobile menu
    And I select Sort By as Name
    Then I should see all products sorted by name

  @secondScenario
  Scenario: Verify Sony Xperia mobile price on list and detail pages
    Given I am on the TechPanda homepage
    When I click on the Mobile menu
    And I read the cost of the Sony Xperia mobile and note it down
    And I click on the Sony Xperia mobile
    Then I read the cost of Sony Xperia mobile from the detail page
    And I compare the values from the list and detail pages

  @thirdScenario
  Scenario: Verify error message when quantity exceeds limit and empty cart
    Given I am on the TechPanda homepage
    When I click on the Mobile menu
    And I add Sony Xperia to the cart
    And I change the QTY value to 1000 and click on the UPDATE button
    Then I should see an error message
    When I click on the EMPTY CART link
    Then I should see that the cart is empty
  
  @fourthScenario  
  Scenario: Compare two mobile products
    Given I am on the TechPanda homepage
    When I click on the Mobile menu
    And I click on add to compare for two mobiles
    And I click on the compare button
    Then I should see a pop-up window with the selected products
    When I close the pop-up window

  @fifthScenario
  Scenario: Register a new user and share a wishlist
    Given I am on the TechPanda homepage
    When I click on the My Account link
    And I click on the Create Account link
    And I fill in the new user information
    And I click on Register
    Then I should see the registration confirmation
    When I go to the TV menu
    And I add a product to my wishlist
    And I click SHARE WISH LIST
    And I enter an email and a message on the next page
    And I click SHARE WISH LIST again
    Then I should see that the wishlist has been shared
    And I log out

  @sixthScenario
  Scenario: Checkout with wishlist item and place order
   Given I am on the TechPanda homepage
   When I click on the My Account link
   And I am logged in with previously created credentials
   When I navigate to the wishlist page
   And I add a product to cart from wishlist
   And I proceed to checkout
   And I enter billing information
   And I enter shipping information
   And I estimate shipping cost
   And I select shipping method and continue
   And I select payment method as Check Money Order and continue
   And I verify shipping cost is generated
   And I select shipping cost and subtotal
   And I verify shipping cost is added to total
   And I place the order
   Then I verify the order is generated and note the order number

  @seventhScenerio
  Scenario: Verify previous order and save as PDF
    Given I am on the TechPanda homepage
    When I click on the My Account link
    And I am logged in with previously created credentials
    And I click on MY ORDERS link
    And I click on the View ORDERS link
    Then I should see the previously created order in the recent orders
    When I click on the Print Order Link
    Then I should see the order saved as a PDF

  @eighthScenerio
  Scenario: Reorder a previous order with updated quantity
    Given I am on the TechPanda homepage
    When I click on the My Account link
    And I am logged in with previously created credentials
    And I click on the REORDERS link
    And I change the QTY and click on UPDATE
    Then I should see the grand total changed
    When I complete the billing and shipping information
    Then I should see that the order is generated and note the order number

  Scenario: Apply coupon code and verify discount
    Given I am on the TechPanda homepage
    When I go to Mobile and add IPHONE to the cart
    And I enter a coupon code
    Then I should see the discount generated

  Scenario: Export orders to CSV and email
    Given I am on the TechPanda homepage
    When I log in using the previously created credentials
    And I go to "Sales > Orders" menu
    And I select CSV in the Export To dropdown and click on Export
    Then I should see the exported file downloaded
    When I read the downloaded file and display the order information in the console
    And I attach the exported file and email it to another email ID
