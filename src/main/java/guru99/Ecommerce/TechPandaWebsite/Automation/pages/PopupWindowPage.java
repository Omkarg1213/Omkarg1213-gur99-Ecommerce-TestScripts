package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import java.util.List;
import java.util.Set;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupWindowPage {

    WebDriver driver;
    WebDriverWait wait;
    String parentWindowHandle;

    By productsNameField = By.xpath("//h2[@class='product-name']");
    By closeWindowField = By.xpath("//button[@title='Close Window']");

    public PopupWindowPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        this.parentWindowHandle = driver.getWindowHandle();
    }

    public void switchToPopupWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to popup window: " + windowHandle);
                driver.manage().window().maximize();
                break;
            }
        }
    }

    public boolean verifySelectedCompareProds() {
        switchToPopupWindow();
        List<WebElement> productsNameFieldElement = driver.findElements(productsNameField);
        boolean prod1 = productsNameFieldElement.get(0).isDisplayed();
        boolean prod2 = productsNameFieldElement.get(1).isDisplayed();
        System.out.println("Mobiles added to compare are:\n" + productsNameFieldElement.get(0).getText() 
        		            + "\n" + productsNameFieldElement.get(1).getText());
        return prod1 && prod2;
    }

    public void closeWindow() {
        switchToPopupWindow();

        try {
            // Wait for the close button to be clickable and then click it
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeWindowField));
            closeButton.click();
            System.out.println("Close button clicked");

            // Switch back to the parent window
            // driver.switchTo().window(parentWindowHandle);
            // System.out.println("Switched back to parent window: " + parentWindowHandle);
        } catch (Exception e) {
            System.out.println("Failed to close the popup window: " + e.getMessage());
            throw e;
        }
    }
}
