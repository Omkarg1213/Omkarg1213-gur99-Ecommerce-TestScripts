package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
    By mobileField = By.xpath("(//a[@class='level0 '])[1]");
    By tvField = By.xpath("(//a[@class='level0 '])[2]");
    By myAccountField = By.xpath("(//a[@title='My Account'])[2]");

    public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public  void clickOnMobileField() {
	   driver.findElement(mobileField).click();
    }

    public  void clickOnTVField() {
       driver.findElement(tvField).click();
    }

    public  void clickMyAccountField() {
       driver.findElement(myAccountField).click();
    }
}
