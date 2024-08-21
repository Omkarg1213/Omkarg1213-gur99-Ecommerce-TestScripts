package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileDetailPage {
	WebDriver driver;
	
	By priceField = By.xpath("//span[@class='price']");

	public MobileDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSonyXperiaPriceFromDetailPage() {
		return driver.findElement(priceField).getText();
	}
}
