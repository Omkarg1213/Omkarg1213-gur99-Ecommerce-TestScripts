package guru99.Ecommerce.TechPandaWebsite.Automation.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage {

    private WebDriver driver;
    private Properties config;

    // Locators
    private By viewOrderLink = By.xpath("//a[text()='View Order']");
    private By orderNumberElement = By.xpath("//h1[starts-with(text(), 'Order #')]");
    private By printOrderLink = By.xpath("//a[text()='Print Order']"); 
    private By ReOrderLink = By.xpath("//a[text()= 'Reorder']"); 
    private By QTY = By.xpath("//input[@title='Qty']"); 
    private By updateButton = By.xpath("//button[@title='Update']");
    private By price = By.xpath("//span[@class='price']");

    public OrderHistoryPage(WebDriver driver, Properties config) {
        this.driver = driver;
        this.config = config;
    }

    // Click on the "View Order" link
    public void clickViewOrdersLink() {
        driver.findElement(viewOrderLink).click();
    }

    // Get and return the order number from the recent orders
    public String verifyOrderInRecentOrders() {
        WebElement orderElement = driver.findElement(orderNumberElement);
        String orderNumberText = orderElement.getText(); // e.g., "Order #100023058 - Pending"
        return orderNumberText.split("#")[1].split("-")[0].trim(); // Extracts "100023058"
    }

    // Click on the "Print Order" link
    public void clickPrintOrderLink() {
        driver.findElement(printOrderLink).click();
    }

    // Automates the printing process and verification of the order as a PDF
    public void printOrderAndVerify() throws AWTException, InterruptedException {
        automatePrint("order.pdf");
        // verifyOrderPdfGenerated(); // Uncomment to enable PDF verification
        // System.out.println("Order was successfully printed and verified as a PDF.");
    }

    // Automate the print process using the Robot class
    public static void automatePrint(String fileName) throws AWTException, InterruptedException {
    	   Robot robot = new Robot();

    	    // Ensure the print dialog has enough time to appear
    	    Thread.sleep(3000);

    	    // Press Enter to confirm the print dialog
    	    robot.keyPress(KeyEvent.VK_ENTER);
    	    robot.keyRelease(KeyEvent.VK_ENTER);

    	    // Pause to allow the system to react
    	    Thread.sleep(3000);

    	    // Copy the file path to the clipboard
    	    StringSelection filePath = new StringSelection("C:\\Users\\Omkar G\\Downloads\\" + fileName);
    	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

    	    // Paste the file path from the clipboard
    	    robot.keyPress(KeyEvent.VK_CONTROL);
    	    robot.keyPress(KeyEvent.VK_V);
    	    robot.keyRelease(KeyEvent.VK_V);
    	    robot.keyRelease(KeyEvent.VK_CONTROL);

    	    // Pause again to ensure the path is pasted
    	    Thread.sleep(2000);

    	    // Confirm the file path selection by pressing Enter
    	    robot.keyPress(KeyEvent.VK_ENTER);
    	    robot.keyRelease(KeyEvent.VK_ENTER);

    	    // Allow time for the system to process the print
    	    Thread.sleep(5000);

    	    // Tab through the dialog and finalize the print
    	    robot.keyPress(KeyEvent.VK_TAB);
    	    robot.keyRelease(KeyEvent.VK_TAB);

    	    Thread.sleep(1000);  // Small delay to ensure tab is processed

    	    // Press Enter to finalize
    	    robot.keyPress(KeyEvent.VK_ENTER);
    	    robot.keyRelease(KeyEvent.VK_ENTER);

    	    // Wait for the print process to complete
    	    Thread.sleep(5000);
    }

	public void clickReordersLink() {
		 driver.findElement(ReOrderLink).click();
	}

	

    /*
     * Optional method to verify if the order PDF was generated correctly.
     * Uncomment and customize the tessDataPath as needed.
     */
    /*
    public void verifyOrderPdfGenerated() {
        String tessDataPath = "path_to_tessdata"; // Update with actual path to your tessdata folder
        String downloadDir = "C:\\Users\\Omkar G\\Downloads";
        String expectedPdfFileName = "order.pdf";
        File pdfFile = new File(downloadDir + File.separator + expectedPdfFileName);

        System.out.println("Checking file at: " + pdfFile.getAbsolutePath());

        if (!pdfFile.exists()) {
            throw new AssertionError("PDF file was not saved. File path: " + pdfFile.getAbsolutePath());
        }

        try (FileInputStream fis = new FileInputStream(pdfFile); PDDocument document = PDDocument.load(fis)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String pdfText = pdfStripper.getText(document);

            System.out.println("Extracted PDF Text: '" + pdfText + "'");

            String expectedOrderNumber = config.getProperty("orderNumber").trim();
            String formattedPdfText = pdfText.replaceAll("\\s+", " ").trim();

            System.out.println("Expected Order Number: '" + expectedOrderNumber + "'");
            System.out.println("Formatted PDF Text: '" + formattedPdfText + "'");

            if (!formattedPdfText.contains(expectedOrderNumber)) {
                throw new AssertionError("PDF does not contain the expected order number.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new AssertionError("Failed to read the PDF file.");
        }
    }
    */
}
