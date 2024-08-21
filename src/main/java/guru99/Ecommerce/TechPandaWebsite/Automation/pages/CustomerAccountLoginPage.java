package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerAccountLoginPage {
	WebDriver driver;
	By createAccountField = By.xpath("//span[text()='Create an Account']");
	By emailToLogin = By.id("email");
	By passwordToLogin = By.id("pass");
	By butoonToLogin = By.id("send2");
	
	public CustomerAccountLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCreateField() {
		driver.findElement(createAccountField).click();
	}

	public void toLogin(String email, String password) {
		driver.findElement(emailToLogin).sendKeys(email);
		driver.findElement(passwordToLogin).sendKeys(password);
		driver.findElement(butoonToLogin).click();
	}

}
