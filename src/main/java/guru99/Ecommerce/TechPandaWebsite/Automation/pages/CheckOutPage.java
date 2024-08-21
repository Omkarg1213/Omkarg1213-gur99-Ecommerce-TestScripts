package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
	WebDriver driver;
	Select select;
	
	//locator to verify Header of cart
	By emptyCartHeader = By.xpath("//h1[text()='Shopping Cart is Empty']");
	
	//locators for billing informations 
	By firstNameField = By.id("billing:firstname");
	By middleNameField = By.id("billing:middlename");
	By lastNameField = By.id("billing:lastname");
	By companyNameField = By.id("billing:company");
	By addressField = By.id("billing:street1");
	By streetAddressField = By.id("billing:street2");
	By cityField = By.id("billing:city");
	By stateField = By.id("billing:region_id");  //drop down
	By zipField = By.id("billing:postcode");
	By countryField = By.id("billing:country_id"); // drop down
	By telephoneField = By.id("billing:telephone");
	By faxField = By.id("billing:fax");
	
	//locators for shipping informations
	By shipToThisRadioBtn = By.id("billing:use_for_shipping_yes"); 
	
	//locator for continue button
	By continueButton = By.xpath("//span[text()='Continue']");
	
	//locatrors for shipping method
	By flatPriceField = By.xpath("//span[text()='$5.00']");
	
	//locators for Order payment method
	private By subtotalElement = By.xpath("//*[@id='checkout-review-table']/tfoot/tr[1]/td[2]/span");
    private By shippingCostElement = By.xpath("//*[@id='checkout-review-table']/tfoot/tr[2]/td[2]/span");
    private By grandTotalElement = By.xpath("//*[@id='checkout-review-table']/tfoot/tr[3]/td[2]/strong/span");
	
	//locators for payment method
	By moneyOrderRadioBtn = By.id("p_method_checkmo");
	
	//place order button 
	By placeOrderButton = By.xpath("//span[text()='Place Order']");
	
	// Locator for the order confirmation message
    private By orderConfirmationMessage = By.xpath("//h1[text()='Your order has been received.']"); 

    // Locator for the order number
    private By orderNumberField = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a"); 
	
    //locators of Billing information radio button ship to this address or different address
    By billingAddressShippingOption = By.xpath("//input[@name='billing[use_for_shipping]']");
    
	public CheckOutPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public String verifyEmptyCartHeader() {
		return driver.findElement(emptyCartHeader).getText().trim();
	}

	public void enterBillingInfo(String firstName, String middleName, String lastName, String company, String address1, String address2, String city, String state, String zip, String country, String telephone, String fax) {
	    driver.findElement(firstNameField).clear();
	    driver.findElement(firstNameField).sendKeys(firstName);
	    
	    driver.findElement(middleNameField).clear();
	    driver.findElement(middleNameField).sendKeys(middleName);
	    
	    driver.findElement(lastNameField).clear();
	    driver.findElement(lastNameField).sendKeys(lastName);
	    
	    driver.findElement(companyNameField).clear();
	    driver.findElement(companyNameField).sendKeys(company);
	    
	    driver.findElement(addressField).clear();
	    driver.findElement(addressField).sendKeys(address1);
	    
	    driver.findElement(streetAddressField).clear();
	    driver.findElement(streetAddressField).sendKeys(address2);
	    
	    driver.findElement(cityField).clear();
	    driver.findElement(cityField).sendKeys(city);
	    
	    // For dropdowns, use Select class
	    Select stateDropdown = new Select(driver.findElement(stateField));
	    stateDropdown.selectByVisibleText(state);
	    
	    driver.findElement(zipField).clear();
	    driver.findElement(zipField).sendKeys(zip);
	    
	    Select countryDropdown = new Select(driver.findElement(countryField));
	    countryDropdown.selectByVisibleText(country);
	    
	    driver.findElement(telephoneField).clear();
	    driver.findElement(telephoneField).sendKeys(telephone);
	    
	    driver.findElement(faxField).clear();
	    driver.findElement(faxField).sendKeys(fax);
	}

	public void enterShippingInfo() {
		driver.findElement(shipToThisRadioBtn).click(); 
		driver.findElements(continueButton).get(0).click();
	}

	public double estimateShippingCost() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    String shippingCostText = driver.findElement(flatPriceField).getText();
	    shippingCostText = shippingCostText.replace("$", "").replace(",", "");
	    return Double.parseDouble(shippingCostText);
	}

	public void shippingMethodContinue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElements(continueButton).get(2).click();
	}

	public void paymentMethod() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(moneyOrderRadioBtn).click();
		driver.findElements(continueButton).get(3).click();
	}

	 public String getSubTotal() {
	        return driver.findElement(subtotalElement).getText();
	    }

	    public String getShippingCost() {
	        return driver.findElement(shippingCostElement).getText();
	    }

	    public String getGrandTotal() {
	        return driver.findElement(grandTotalElement).getText();
	    }


	public void clickPlaceOrderButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(placeOrderButton).click();
	}

	public String getOrderConfirmationMessage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String message = driver.findElement(orderConfirmationMessage).getText();
		System.out.println(message);
		return message;
	}

	public String getOrderNumber() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver.findElement(orderNumberField).getText();
	}

	public void billingAddressShippingOptionToThisAddress() {
		driver.findElements(billingAddressShippingOption).get(0).click();
		driver.findElements(continueButton).get(0).click();
	}
}
