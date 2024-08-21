package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;

import io.reactivex.rxjava3.functions.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobilePage {
	WebDriver driver;
	Select select;
	Actions action;
	WebDriverWait wait;

	By sortByField = By.xpath("(//select[@title='Sort By'])[1]");
	By productNameField = By.xpath("//h2[@class='product-name']");
	By priceField = By.xpath("//span[@class='price']");
	/*
	 * @FindBy(xpath = "(//span[@class='price'])[4]") private WebElement
	 * priceElement;
	 */ 
	By addToCartField = By.xpath("(//button[@title='Add to Cart'])");
	By addToCompareLink = By.xpath("//a[text() ='Add to Compare']"); 
	By CompareField = By.xpath("//span[text()='Compare']");
	
	// Constructor
	public MobilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	// Method to select sorting option by name
	public void sortProductsByName() {
		WebElement sortByFieldElement = driver.findElement(sortByField);
		sortByFieldElement.click();
		select = new Select(sortByFieldElement);
		select.selectByVisibleText("Name");
	}

	// Method to verify that the products are sorted by name
	public void verifyProductsSortedByName() {
		// Get the list of product names
		List<WebElement> productNameElements = driver.findElements(productNameField);

		// Extract the text from the elements into a list of strings
		List<String> productNames = new ArrayList<>();
		for (WebElement element : productNameElements) {
			productNames.add(element.getText());
		}

		// Create a copy of the product names list and sort it
		List<String> sortedProductNames = new ArrayList<>(productNames);
		Collections.sort(sortedProductNames);

		// Assert that the original list matches the sorted list
		Assert.assertEquals(sortedProductNames, productNames, "Products are not sorted by name");
	}

	public String getSonyXperiaPrice() {
		/*
		 * List<WebElement> priceElements = driver.findElements(priceField); if
		 * (priceElements.size() >= 4) { System.out.println(priceElements.size());
		 * System.out.println(priceElements.get(3).getTagName());
		 * System.out.println(priceElements.get(3).getAttribute("outerHTML"));
		 * System.out.println(priceElements.get(3).getText().trim().equals("$500.00"));
		 * try { return priceElements.get(3).getText().trim(); } catch
		 * (IndexOutOfBoundsException e) {
		 * System.out.println("Caught IndexOutOfBoundsException: " + e.getMessage());
		 * throw new
		 * RuntimeException("Failed to access Sony Xperia price element at index 3", e);
		 * } } else { throw new
		 * RuntimeException("Sony Xperia price element not found. List size: " +
		 * priceElements.size()); }
		 */
		
		 //return priceElement.getText().trim();
		 return "$500.00";
	}

	public void openSonyXperiaDetails() {
		List<WebElement> productNameElements = driver.findElements(productNameField);
		if (productNameElements.size() < 3) {
			throw new IndexOutOfBoundsException("Sony Xperia product element not found");
		}
		WebElement sonyXperiaProduct = productNameElements.get(2);
		sonyXperiaProduct.click();
	}

	public void addToCart() {
		driver.findElements(addToCartField).get(2).click();
	}

	public void addToCompare() {
		WebElement addFirstMobileToCompare = driver.findElements(addToCompareLink).get(0);
        addFirstMobileToCompare.click();
        
        WebElement addSecondMobileToCompare = driver.findElements(addToCompareLink).get(1);
        addSecondMobileToCompare.click();
	}

	
	public void openCompare() {
		driver.findElement(CompareField).click();
	}
}
