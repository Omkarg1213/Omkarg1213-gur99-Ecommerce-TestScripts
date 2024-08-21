package guru99.Ecommerce.TechPandaWebsite.Automation.stepDefinition;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.tika.exception.TikaException;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import guru99.Ecommerce.TechPandaWebsite.Automation.driverFactory.DriverFactory;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.CartPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.CheckOutPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.CustomerAccountCreationPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.CustomerAccountIndexPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.CustomerAccountLoginPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.HomePage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.MobileDetailPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.MobilePage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.OrderHistoryPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.PopupWindowPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.TvPage;
import guru99.Ecommerce.TechPandaWebsite.Automation.pages.WishListPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
    private WebDriver driver;
    private Properties config;
    private SoftAssert softAssert;
    private HomePage homePage;
    private MobilePage mobilePage;
    private MobileDetailPage mobileDetailPage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;
    private PopupWindowPage popupWindowPage;
    private CustomerAccountLoginPage customerAccountLoginPage;
    private CustomerAccountCreationPage customerAccountCreationPage;
    private CustomerAccountIndexPage customerAccountIndexPage;
    private TvPage tvPage;
    private WishListPage wishListPage;
    private OrderHistoryPage orderHistoryPage;
    public StepDefinition stepDefinition;
    
    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        config = new Properties();
        softAssert = new SoftAssert();
        config = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file", e);
        }
        
        String browser = config.getProperty("browser");
        if (browser == null) {
            browser = "chrome"; // Default browser if not specified
        }

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver(browser);
        
        homePage = new HomePage(driver);
        mobilePage = new MobilePage(driver);
        mobileDetailPage = new MobileDetailPage(driver);
        cartPage = new CartPage(driver);
        this.checkOutPage = new CheckOutPage(driver);
        popupWindowPage = new PopupWindowPage(driver);
        customerAccountLoginPage = new CustomerAccountLoginPage(driver);
        customerAccountCreationPage = new CustomerAccountCreationPage(driver);
        customerAccountIndexPage = new CustomerAccountIndexPage(driver);
        tvPage = new TvPage(driver);
        wishListPage = new WishListPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver, config);
        stepDefinition = new StepDefinition();
    }

    @Given("I am on the TechPanda homepage")
    public void i_am_on_the_tech_panda_homepage() {
        String applicationUrl = config.getProperty("AUTLINK");
        if (applicationUrl == null) {
            throw new RuntimeException("URL is not defined in the config.properties file");
        }
        driver.get(applicationUrl);
        driver.manage().window().maximize();
    }

    @When("I click on the Mobile menu")
    public void i_click_on_the_mobile_menu() {
    	homePage.clickOnMobileField();
    }
    
    @When("I select Sort By as Name")
    public void i_select_sort_by_as_name() {
    	mobilePage.sortProductsByName();
    }

    @Then("I should see all products sorted by name")
    public void i_should_see_all_products_sorted_by_name() {
        mobilePage.verifyProductsSortedByName();
    }

	@When("I read the cost of the Sony Xperia mobile and note it down")
	public void i_read_the_cost_of_the_sony_xperia_mobile_and_note_it_down() {
		String sonyXperiaPrice = mobilePage.getSonyXperiaPrice();
        System.out.println("sonyXperiaPrice : "+sonyXperiaPrice);
	}

	@When("I click on the Sony Xperia mobile")
	public void i_click_on_the_sony_xperia_mobile() {
		mobilePage.openSonyXperiaDetails();
	}

	@Then("I read the cost of Sony Xperia mobile from the detail page")
	public void i_read_the_cost_of_sony_xperia_mobile_from_the_detail_page() {
		String sonyXperiaPriceOnDetailPage = mobileDetailPage.getSonyXperiaPriceFromDetailPage();
		System.out.println("sonyXperiaPriceOnDetailPage : "+sonyXperiaPriceOnDetailPage);
	}

	@Then("I compare the values from the list and detail pages")
	public void i_compare_the_values_from_the_list_and_detail_pages() {
	    // Ensure mobileDetailPage is properly initialized, assuming you already have it defined
	    String listPagePrice = mobilePage.getSonyXperiaPrice();
	    String detailPagePrice = mobileDetailPage.getSonyXperiaPriceFromDetailPage();

	    // Perform the comparison using soft assertions
	    softAssert.assertEquals(listPagePrice, detailPagePrice, "Prices do not match between list and detail pages");

	    // Trigger the assertion and report any failures
	    softAssert.assertAll();
	}

	@When("I add Sony Xperia to the cart")
	public void i_add_sony_xperia_to_the_cart() {
		mobilePage.addToCart();
	}

	@When("I change the QTY value to 1000 and click on the UPDATE button")
	public void i_change_the_value_to_and_click_on_the_button() {
	    cartPage.setQuantityAndUpdate(config.getProperty("INVALID_QUANTITY"));
	}

	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		String errorMessgae = cartPage.verifyErrorMessage();
		softAssert.assertEquals(errorMessgae, config.getProperty("errorMessage"),"Error Message do not match");
	}

	@When("I click on the EMPTY CART link")
	public void i_click_on_the_link() {
		cartPage.clickEmptyCartLink();
	}

	@Then("I should see that the cart is empty")
	public void i_should_see_that_the_cart_is_empty() {
		String emptyCartHeader = checkOutPage.verifyEmptyCartHeader();
		softAssert.assertEquals(emptyCartHeader, config.getProperty("emptyCartHeader"), "Empty Cart Header do not match");
		softAssert.assertAll();
	}

	@When("I click on add to compare for two mobiles")
	public void i_click_on_for_two_mobiles() {
		mobilePage.addToCompare();
	}

	@When("I click on the compare button")
	public void i_click_on_the_button() {
		mobilePage.openCompare();
	}

	@Then("I should see a pop-up window with the selected products")
	public void i_should_see_a_pop_up_window_with_the_selected_products() {
		boolean flag = popupWindowPage.verifySelectedCompareProds();
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}

	@When("I close the pop-up window")
	public void i_close_the_pop_up_window() {
		popupWindowPage.closeWindow();
	}
	
	@When("I click on the My Account link")
	public void i_click_on_the_my_account_link() {
	    homePage.clickMyAccountField();
	}
	
	@When("I click on the Create Account link")
	public void i_click_on_the_create_account_link() {
		customerAccountLoginPage.clickCreateField();
	}
	
	@When("I fill in the new user information")
	public void i_fill_in_the_new_user_information() {
		
		homePage.clickMyAccountField();
		customerAccountLoginPage.clickCreateField();
		
		String firstName = config.getProperty("firstName");
		String middleName = config.getProperty("middleName");
		String lastName = config.getProperty("lastName");
		String email = config.getProperty("emailForRegistration");
		String password = config.getProperty("password");
		String confirmPassword = config.getProperty("confirmPassword");
		
		customerAccountCreationPage.fillNewUserInfo(firstName, middleName, lastName, email, password, confirmPassword);
	}

	@When("I click on Register")
	public void i_click_on_register() {
		customerAccountCreationPage.clickRegister();
	}

	@Then("I should see the registration confirmation")
	public void i_should_see_the_registration_confirmation() {
		boolean flag = customerAccountIndexPage.verifyRegistrationConfirm();
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}

	@When("I go to the TV menu")
	public void i_go_to_the_tv_menu() {
		customerAccountIndexPage.clickTvMenu();
	}

	@When("I add a product to my wishlist")
	public void i_add_a_product_to_my_wishlist() {
		tvPage.addProductToMyWishList();
	}

	@When("I click SHARE WISH LIST")
	public void i_click() {
		wishListPage.shareWishList();
	}

	@When("I enter an email and a message on the next page")
	public void i_enter_an_email_and_a_message_on_the_next_page() {
		String receiceremail = config.getProperty("receiverEmail");
		String message = config.getProperty("message");
		wishListPage.enterEmailAndMessage(receiceremail,message);
	}

	@When("I click SHARE WISH LIST again")
	public void i_click_again() {
		wishListPage.shareWishList();
	}

	@Then("I should see that the wishlist has been shared")
	public void i_should_see_that_the_wishlist_has_been_shared() {
		boolean flag = wishListPage.verifyShareWishListConfirmation();
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}

	@Then("I log out")
	public void i_log_out() {
		wishListPage.logOut();
	}
	
	@When("I am logged in with previously created credentials")
	public void i_am_logged_in_with_previously_created_credentials() {
		String email = config.getProperty("emailForRegistration");
		String password = config.getProperty("password");
		customerAccountLoginPage.toLogin(email, password);
	}

	@When("I navigate to the wishlist page")
	public void i_navigate_to_the_wishlist_page() {
		customerAccountIndexPage.clickMyWishList();
	}

	@When("I add a product to cart from wishlist")
	public void i_add_a_product_to_cart_from_wishlist() {
		wishListPage.addToCart();
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		cartPage.proceedToCheckout();
	}

	@When("I enter billing information")
	public void i_enter_billing_information() {
	    String firstName = config.getProperty("firstName");
	    String middleName = config.getProperty("middleName");
	    String lastName = config.getProperty("lastName");
	    String company = config.getProperty("company");
	    String address1 = config.getProperty("address1");
	    String address2 = config.getProperty("address2");
	    String city = config.getProperty("city");
	    String state = config.getProperty("state");
	    String zip = config.getProperty("zip");
	    String country = config.getProperty("country");
	    String telephone = config.getProperty("telephone");
	    String fax = config.getProperty("fax");

	    checkOutPage.enterBillingInfo(firstName, middleName, lastName, company, address1, address2, city, state, zip, country, telephone, fax);
	}


	@When("I enter shipping information")
	public void i_enter_shipping_information() {
		checkOutPage.enterShippingInfo();
	}

	@When("I estimate shipping cost")
	public void i_estimate_shipping_cost() {
		double flatRatePrice = checkOutPage.estimateShippingCost();
		System.out.println("flatRatePrice : "+flatRatePrice);
	}

	@When("I select shipping method and continue")
	public void i_select_shipping_method_and_continue() {
		checkOutPage.shippingMethodContinue();
	}

	@When("I select payment method as Check Money Order and continue")
	public void i_select_payment_method_as_and_continue() {
		checkOutPage.paymentMethod();
	}

	@When("I verify shipping cost is generated")
	public void i_verify_shipping_cost_is_generated() {
		String shippingCost = checkOutPage.getShippingCost();
		 softAssert.assertNotNull(shippingCost, "Shipping cost should be generated");
		 softAssert.assertFalse(shippingCost.isEmpty(), "Shipping cost should not be empty");
		    
		 // Assert all to ensure that all assertions are verified
		 softAssert.assertAll();
	}

	@When("I select shipping cost and subtotal")
	public void i_select_shipping_cost_and_subtotal() {
		String shippingCost = checkOutPage.getShippingCost();
	    String subTotal = checkOutPage.getSubTotal();

	    softAssert.assertNotNull("Shipping cost should be selected", shippingCost);
	    softAssert.assertNotNull("Subtotal should be selected", subTotal);
	    softAssert.assertAll();
	}

	@When("I verify shipping cost is added to total")
	public void i_verify_shipping_cost_is_added_to_total() {
	    double shippingCost = Double.parseDouble(checkOutPage.getShippingCost().replace("$", ""));
	    double subTotal = Double.parseDouble(checkOutPage.getSubTotal().replace("$", ""));
	    double total = Double.parseDouble(checkOutPage.getGrandTotal().replace("$", ""));

	    // Storing grand total in config
	    config.setProperty("grandTotal", checkOutPage.getGrandTotal().replace("$", ""));

	    softAssert.assertEquals(total, subTotal + shippingCost, 0.01, "Total should be sum of subtotal and shipping cost");
	    
	    // Assert all to ensure that all assertions are verified
	    softAssert.assertAll();
	}

	@When("I place the order")
	public void i_place_the_order() {
	    checkOutPage.clickPlaceOrderButton();
	}

	@Then("I verify the order is generated and note the order number")
	public void i_verify_the_order_is_generated_and_note_the_order_number() {
		// Verify the order confirmation message is displayed
	    String confirmationMessage = checkOutPage.getOrderConfirmationMessage();
	    softAssert.assertTrue(confirmationMessage.contains(config.getProperty("orderConfirmationMessage")), 
	                          "Order confirmation message should be displayed");

	    // Extract and note the order number
	    String orderNumber = checkOutPage.getOrderNumber();
	    softAssert.assertNotNull(orderNumber, "Order number should not be null");
	    softAssert.assertFalse(orderNumber.isEmpty(), "Order number should not be empty");

	    // Log the order number for reference
	    System.out.println("Order Number: " + orderNumber);
	    
	    // Store the order number in the configuration for later use
	    config.setProperty("orderNumber", orderNumber);

	    // Save the properties to the config.properties file
	    try (FileOutputStream output = new FileOutputStream("src\\test\\resources\\config.properties")) {
	        config.store(output, null);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Assert all to ensure all assertions are verified
	    softAssert.assertAll();
	}
	
    @When("I click on MY ORDERS link")
    public void i_click_on_my_orders_link() {
    	customerAccountIndexPage.clickMyOrders();
    }

    @When("I click on the View ORDERS link")
    public void i_click_on_the_view_orders_link() {
        orderHistoryPage.clickViewOrdersLink();
    }

    @Then("I should see the previously created order in the recent orders")
    public void i_should_see_the_previously_created_order_in_the_recent_orders() {
    	String actualOrderNumber = config.getProperty("orderNumber");
    	String expectedOrderNumber = orderHistoryPage.verifyOrderInRecentOrders();
    	softAssert.assertEquals(actualOrderNumber, expectedOrderNumber, "Order number should match");
    }

    @When("I click on the Print Order Link")
    public void i_click_on_the_place_order_button() {
    	orderHistoryPage.clickPrintOrderLink();
    	
    	 // Handle the new window or tab
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    @Then("I should see the order saved as a PDF")
    public void i_should_see_the_order_saved_as_a_pdf() throws AWTException, InterruptedException, TikaException {
    	orderHistoryPage.printOrderAndVerify();
    }

    @When("I click on the REORDERS link")
    public void i_click_on_the_reorders_link() {
    	orderHistoryPage.clickReordersLink();
    }

    @When("I change the QTY and click on UPDATE")
    public void i_change_the_qty_and_click_on_update() {
    	cartPage.setQuantityAndUpdate(config.getProperty("QTY"));
    }

    @Then("I should see the grand total changed")
    public void i_should_see_the_grand_total_changed() {
        String newGrandTotal = cartPage.getGrandTotal();
        String oldGrandTotal = config.getProperty("grandTotal");
        System.out.println("newGrandTotal:"+newGrandTotal+"\n"+"oldGrandTotal:"+oldGrandTotal);
        softAssert.assertNotEquals(newGrandTotal, oldGrandTotal, "Grand total should have changed");
        cartPage.proceedToCheckout();
    }

    @When("I complete the billing and shipping information")
    public void i_complete_the_billing_and_shipping_information() {
    	checkOutPage.billingAddressShippingOptionToThisAddress();
    	i_enter_shipping_information();
    	i_select_shipping_method_and_continue();
    	stepDefinition.i_select_payment_method_as_and_continue();
    	stepDefinition.i_place_the_order(); 	
    }

    @Then("I should see that the order is generated and note the order number")
    public void i_should_see_that_the_order_is_generated_and_note_the_order_number() {
    	stepDefinition.i_verify_the_order_is_generated_and_note_the_order_number();
    }

	@When("I go to {string} and add {string} to the cart")
	public void i_go_to_and_add_to_the_cart(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter a coupon code")
	public void i_enter_a_coupon_code() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see the discount generated")
	public void i_should_see_the_discount_generated() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I go to {string} menu")
	public void i_go_to_menu(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I select {string} in the {string} dropdown and click on {string}")
	public void i_select_in_the_dropdown_and_click_on(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should see the exported file downloaded")
	public void i_should_see_the_exported_file_downloaded() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I read the downloaded file and display the order information in the console")
	public void i_read_the_downloaded_file_and_display_the_order_information_in_the_console() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I attach the exported file and email it to another email ID")
	public void i_attach_the_exported_file_and_email_it_to_another_email_id() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
