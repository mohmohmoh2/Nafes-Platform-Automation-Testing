package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Utility.clickingOnElement;
import static Utilities.Utility.uploadFileRobot;

public class P05_MyRFPs {
    private final WebDriver driver;
    // Locators
    private final By uploadRFPButton = By.xpath("//button[@class=\"btn addKoraseh\"]");
    private final By searchForMonafsaButton = By.xpath("//*[contains(@id, 'react-aria-') and contains(@id, '-tab-1')]");
    private final By monafsaSearchInput = By.cssSelector("div.row > div:nth-child(1) > div > input");
    private final By monafsaSearchButton = By.cssSelector("div.row > div:nth-child(1) > div > button");
    private final By uploadRFPButton2 = By.cssSelector("div:nth-child(1) > div.btn-container > button.icons-wrapper2");
    private final By closeButton = By.xpath("//button[@class=\"close-modal\"]");

    private final By menuButton = By.cssSelector(".left-side:nth-child(1)");


    public Logger log = LogManager.getLogger();

    // TODO: Create a constructor
    public P05_MyRFPs(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: Create a method to click on the upload RFP button
    public P05_MyRFPs clickUploadRFPButton() {
        clickingOnElement(driver, uploadRFPButton);
        return this;
    }

    // TODO: Create a method to click on the search for Monafsa button
    public P05_MyRFPs clickSearchForMonafsaButton() {
        clickingOnElement(driver, searchForMonafsaButton);
        log.info("Search for Monafsa button clicked");
        return this;
    }

    // TODO: Create a method to enter Monafsa search input
    public P05_MyRFPs enterMonafsaSearchInput(String searchText) {
        driver.findElement(monafsaSearchInput).sendKeys(searchText);
        log.info("Monafsa search input entered: {}", searchText);
        return this;
    }

    // TODO: Create a method to click on the Monafsa search button
    public P05_MyRFPs clickMonafsaSearchButton() {
        clickingOnElement(driver, monafsaSearchButton);
        log.info("Monafsa search icon clicked");
        return this;
    }

    // TODO: Create a method to upload RFP file
    public P05_MyRFPs uploadRFPFile(String filePath) {
        uploadFileRobot(driver, uploadRFPButton2, filePath);
        log.info("RFP file Selected successfully: {}", filePath);
        return this;
    }

    // TODO: Wait for the file upload to complete
    public void waitForFileUpload() {
        // Implement waiting logic if necessary, e.g., wait for a success message or file to appear
        new WebDriverWait(driver, Duration.ofSeconds(130)).until(ExpectedConditions.visibilityOfElementLocated(closeButton));
        log.info("File upload completed successfully");
    }


}
