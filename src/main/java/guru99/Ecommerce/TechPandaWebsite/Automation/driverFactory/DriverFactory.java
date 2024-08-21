package guru99.Ecommerce.TechPandaWebsite.Automation.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // ThreadLocal to ensure that the WebDriver instance is local to the thread
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Method to initialize the WebDriver based on the browser type
    public WebDriver initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        } else {
            throw new IllegalArgumentException("Browser type not supported: " + browser);
        }
        // Maximize the browser window
        getDriver().manage().window().maximize();
        return getDriver();
    }

    // Method to get the current WebDriver instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Method to quit the WebDriver and clean up the ThreadLocal instance
    public static void quitDriver() {	
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}		 
    }
}
