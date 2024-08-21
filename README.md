<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test Cases</title>
</head>
<body>

<h1>Test Cases for TechPanda Website</h1>

<h2>Test Plan Summary Report</h2>
<p>All test cases listed below have been executed successfully, and all have passed.</p>

<table border="1">
    <thead>
        <tr>
            <th>TC_ID</th>
            <th>Test Case Description</th>
            <th>Steps</th>
            <th>Expected Result</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>TC_ID_1</td>
            <td>Verify Item in mobile list page can be sorted by 'name'</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Verify title of the page</li>
                    <li>Click 'mobile' menu</li>
                    <li>In the list of all mobiles, select 'Sort By' dropdown as 'name'</li>
                    <li>Verify all products are sorted by 'name'</li>
                </ol>
            </td>
            <td>
                <ol>
                    <li>Text 'Home page' shown in home.</li>
                    <li>Title 'mobile' is shown on mobile list page</li>
                    <li>All three mobiles sorted by 'name'</li>
                </ol>
            </td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_2</td>
            <td>Verify that cost of product in list page and details page are equal</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Click 'mobile' menu</li>
                    <li>In the list of all mobiles, read the cost of Sony Xperia mobile, and note it down</li>
                    <li>Click on Sony Xperia mobile</li>
                    <li>Read the cost of Sony Xperia mobile from the detail page</li>
                    <li>Compare value in step 3 and step 5</li>
                </ol>
            </td>
            <td>Product value in list and detail page should be equal</td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_3</td>
            <td>Verify that the maximum quantity of a product that can be added to the cart does not exceed the available stock in the store</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Click 'mobile' menu</li>
                    <li>In list of all mobiles click on Sony Xperia</li>
                    <li>Change 'QTY' value to '1000' and click on 'UPDATE' button</li>
                    <li>Verify the error message</li>
                    <li>Then click on 'EMPTY CART' link in footer of list of all mobiles</li>
                    <li>Verify cart is empty</li>
                </ol>
            </td>
            <td>
                <ol>
                    <li>On clicking on update button error message is shown</li>
                    <li>On clicking on 'EMPTY CART' message is shown</li>
                </ol>
            </td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_4</td>
            <td>Verify that you're able to compare two products</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Click 'mobile' menu</li>
                    <li>In list of all mobiles, click on 'add to compare' for two mobiles</li>
                    <li>Click on 'compare' button</li>
                    <li>Verify the pop-up window and check that the products are reflected in it</li>
                    <li>Close the pop-up window</li>
                </ol>
            </td>
            <td>
                <ol>
                    <li>product1= iPhone</li>
                    <li>product2= Samsung galaxy</li>
                    <li>A pop-up window opens with heading as 'COMPARE PRODUCTS' and selected products are present in it</li>
                    <li>Pop-up window is closed</li>
                </ol>
            </td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_5</td>
            <td>Verify you can create account in Ecommerce site and can share wishlist to other people using email</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Click on 'my account' link</li>
                    <li>Click create account link and fill new user information except email id</li>
                    <li>Click on 'Register'</li>
                    <li>Verify Registration is done</li>
                    <li>Go to TV menu</li>
                    <li>Add product in your wish list</li>
                    <li>Click 'SHARE WISH LIST'</li>
                    <li>In next page enter email and a message and click 'SHARE WISH LIST'</li>
                    <li>Check wishlist is shared</li>
                </ol>
            </td>
            <td>
                <ol>
                    <li>Account registration is done</li>
                    <li>WishList shared successfully</li>
                </ol>
            </td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_6</td>
            <td>Verify user is able to purchase product using registered email id</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Click on 'my account' link</li>
                    <li>Login in application using previously created credential</li>
                    <li>Click on MY WISHLIST link</li>
                    <li>In next page, Click ADD TO CART link</li>
                    <li>Click PROCEED TO CHECKOUT</li>
                    <li>Enter Shipping information</li>
                    <li>Click ESTIMATE</li>
                    <li>Verify Shipping cost generated</li>
                    <li>Select Shipping Cost, Update total</li>
                    <li>Verify shipping cost is added to total</li>
                    <li>Click PROCEED TO CHECKOUT</li>
                    <li>Enter Billing Information</li>
                    <li>In Shipping Method, Click Continue</li>
                    <li>In Payment Information select 'Check Money Order' radio button, click continue</li>
                    <li>Click 'Place Order' button</li>
                    <li>Verify Order is generated. Note the order number</li>
                </ol>
            </td>
            <td>
                <ol>
                    <li>Flat Rate Shipping of $5 is generated</li>
                    <li>Shipping cost is added to total product cost</li>
                    <li>Order is placed. Order number is generated</li>
                </ol>
            </td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_7</td>
            <td>Verify that you will be able to save previously placed order as a pdf file</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Click on 'my account' link</li>
                    <li>Login in application using previously created credential</li>
                    <li>Click on MY ORDERS link</li>
                    <li>Click on View ORDERS link</li>
                    <li>Verify the Previously Created order is displayed in the recent orders</li>
                    <li>Click 'Place Order' button</li>
                    <li>Verify Order is saved as pdf</li>
                </ol>
            </td>
            <td>
                <ol>
                    <li>Previously Created order is displayed in the recent orders table and status is pending</li>
                    <li>Order is Saved as PDF</li>
                </ol>
            </td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_8</td>
            <td>Verify you're able to change or reorder previously added product</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Click on 'my account' link</li>
                    <li>Login in application using previously created credential</li>
                    <li>Click on REORDERS link, change QTY and update</li>
                    <li>Verify grand total is changed</li>
                    <li>Complete billing and shipping information</li>
                    <li>Verify order is generated and note the order number</li>
                </ol>
            </td>
            <td>
                <ol>
                    <li>Grand total is changed</li>
                    <li>Order number is generated</li>
                </ol>
            </td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_9</td>
            <td>Verify Discount Coupon works Correctly</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Go to Mobile and add IPHONE to cart</li>
                    <li>Enter Coupon code</li>
                    <li>Verify the discount generated</li>
                </ol>
            </td>
            <td>Phone is discounted by 5%</td>
            <td>Passed</td>
        </tr>
        <tr>
            <td>TC_ID_10</td>
            <td>Export all orders in CSV file and display this information in console and you're able to send this file to another email id as attachment</td>
            <td>
                <ol>
                    <li>Go to <a href="http://live.techpanda.org/index.php/">http://live.techpanda.org/index.php/</a></li>
                    <li>Login in application using previously created credential</li>
                    <li>Go to Sales &gt; Orders menu</li>
                    <li>Select 'CSV' in Export To dropdown and click export button</li>
                    <li>Read downloaded file and display all order information in console Windows</li>
                    <li>Attach this exported file and email to another email id</li>
                </ol>
            </td>
            <td>
                <ol>
                    <li>Console displays all order information</li>
                    <li>Email is sent successfully</li>
                </ol>
            </td>
            <td>Passed</td>
        </tr>
    </tbody>
</table>

<h2>Technologies Used</h2>
<ul>
    <li>Java Selenium</li>
    <li>TestNG</li>
    <li>Page Object Model</li>
    <li>Cucumber</li>
</ul>

<h2>Author</h2>
<p>Documentation created by Omkar G</p>

</body>
</html>
