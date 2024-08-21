package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	By addQuantityField = By.xpath("//input[@class='input-text qty']");
	By updateField = By.xpath("//span[text()='Update']");
	By errorMessageField = By.xpath("//p[@class='item-msg error']");
	By emptyCartLink = By.xpath("//span[text()='Empty Cart']");
	By proceedToCheckoutField = By.xpath("//span[text()='Proceed to Checkout']");
	
    private By price = By.xpath("//span[@class='price']");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setQuantityAndUpdate(String property) {
		driver.findElement(addQuantityField).clear();
		driver.findElement(addQuantityField).sendKeys(property);
		driver.findElement(updateField).click();
	}

	public String verifyErrorMessage() {
		return driver.findElement(errorMessageField).getText();
	}

	public void clickEmptyCartLink() {
		driver.findElement(emptyCartLink).click();
	}

	public void proceedToCheckout() {
		driver.findElements(proceedToCheckoutField).get(0).click();
	}

	public String getGrandTotal() {
		return driver.findElements(price).get(4).getText();		
	}
}
