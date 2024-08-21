package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerAccountCreationPage {
	WebDriver driver;
	By firstNameField = By.id("firstname");
	By middleNameField = By.id("middlename");
	By lastNameField = By.id("lastname");
	By emailAddressField = By.id("email_address");
	By passwordField = By.id("password");
	By confirmationPasswordField = By.id("confirmation");
	By RegisterField = By.xpath("//span[text()='Register']"); 
	By SignUpCheckBox = By.id("is_subscribed");

	public CustomerAccountCreationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillNewUserInfo(String firstName, String middleName, String lastName, String email, String password,
			String confirmPassword) {
		driver.findElement(firstNameField).clear();;
		driver.findElement(firstNameField).sendKeys(firstName);
		
		driver.findElement(middleNameField).clear();
		driver.findElement(middleNameField).sendKeys(middleName);
		
		driver.findElement(lastNameField).clear();
		driver.findElement(lastNameField).sendKeys(lastName);
		
		driver.findElement(emailAddressField).clear();
		driver.findElement(emailAddressField).sendKeys(email);
		
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
		
		driver.findElement(confirmationPasswordField).clear();
		driver.findElement(confirmationPasswordField).sendKeys(confirmPassword);
	}

	public void clickRegister() {
		driver.findElement(SignUpCheckBox).click();
		driver.findElement(RegisterField).click();
	}
}
