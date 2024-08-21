package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerAccountIndexPage {
WebDriver driver;
	
    By registrationConfiramationText = By.xpath("//span[text()='Thank you for registering with Main Website Store.']");
    By tvField = By.xpath("//a[text()='TV']"); 
    By myWishListLink = By.xpath("//a[text()='My Wishlist']"); 
    By myOrdersLink = By.xpath("//a[text()='My Orders']");
    
	public CustomerAccountIndexPage(WebDriver driver) { 
		this.driver = driver;
	}

	public boolean verifyRegistrationConfirm() {
		return driver.findElement(registrationConfiramationText).isDisplayed();
	}

	public void clickTvMenu() {
		driver.findElement(tvField).click();
	} 
	
	public void clickMyWishList() {
		driver.findElement(myWishListLink).click();
	}
	
	public void clickMyOrders() {
		driver.findElement(myOrdersLink).click();
	}
}
