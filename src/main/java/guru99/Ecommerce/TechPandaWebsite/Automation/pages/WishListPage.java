package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
	WebDriver driver;
	
    By shareWishListField = By.xpath("//span[text()='Share Wishlist']");
    By shareWishListEmailField = By.id("email_address");
    By shareWishListMessageField = By.id("message");
    By shareWishListConfirmationText = By.xpath("//span[text()='Your Wishlist has been shared.']");
    By accountField = By.xpath("//span[text()='Account']"); 
    By logOutField = By.xpath("//a[@title='Log Out']");
    By addToCartField = By.xpath("//span[text()='Add to Cart']");
    
	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void shareWishList() {
		driver.findElement(shareWishListField).click();
	}

	public void enterEmailAndMessage(String receiverEmail, String message) {
		driver.findElement(shareWishListEmailField).sendKeys(receiverEmail);
		driver.findElement(shareWishListMessageField).sendKeys(message);
	}
	
	public boolean verifyShareWishListConfirmation() {
		return driver.findElement(shareWishListConfirmationText).isDisplayed();
	}

	public void logOut() {
		driver.findElement(accountField).click();
		driver.findElement(logOutField).click();
	}

	public void addToCart() {
		driver.findElement(addToCartField).click();
	}

}
