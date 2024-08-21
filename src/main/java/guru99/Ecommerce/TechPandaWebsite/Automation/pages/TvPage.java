package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TvPage {
	WebDriver driver;

	By myWishListField = By.xpath("//a[text()='Add to Wishlist']");
	
	public TvPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addProductToMyWishList() {
		driver.findElements(myWishListField).get(0).click();
	}

}
