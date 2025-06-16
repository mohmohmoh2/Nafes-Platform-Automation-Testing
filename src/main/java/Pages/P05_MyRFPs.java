package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Utility.*;

public class P05_MyRFPs {
    private final WebDriver driver;
    // Locators
    private final By uploadRFPButton = By.xpath("//button[@class=\"btn addKoraseh\"]");
    private final By searchForMonafsaButton = By.xpath("//*[contains(@id, 'react-aria-') and contains(@id, '-tab-1')]");
    private final By monafsaSearchInput = By.cssSelector("div.row > div:nth-child(1) > div > input");
    private final By monafsaSearchButton = By.cssSelector("div.row > div:nth-child(1) > div > button");
    private final By uploadRFPButton2 = By.xpath("//*[contains(@id, 'react-aria')]/div[3]/div[1]/div[2]/button[1]");
    private final By closeButton = By.xpath("//button[@class=\"close-modal\"]");

    private final By menuIcons = By.xpath("//div[@class=\"left-side\"]//button");
    private final By deleteRFPTitles = By.xpath("//div[@class=\"tenderName\"]/h5");
    public String deleteRFPTitle;
    private final By deleteRFPButton = By.xpath("//div[@class=\"dropdown-menu show\"]//a[2]");
    private final By confirmDeleteButton = By.xpath("//div[@class=\"swal2-actions\"]/button[1]");

    private final By inStudyingCheckbox = By.xpath("//div[@class=\"form-group status\"][1]//label");
    private final By statusLabels = By.xpath("//div[contains(@class, 'koraseh-status')]/p");

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
        new WebDriverWait(driver, Duration.ofSeconds(130))
                .until(ExpectedConditions.visibilityOfElementLocated(closeButton));
        log.info("File upload completed successfully");
    }

    // TODO: Create a method to get the text of the delete RFP titles
    public String getDeleteRFPTitlesText(int index) {
        deleteRFPTitle = getTextFromList(driver, deleteRFPTitles, index);
        return deleteRFPTitle;
    }

    // TODO: Create a method to click on the menu button
    public P05_MyRFPs clickMenuButton(int elementOrder) {
        int index = elementOrder - 1; // Convert to zero-based index
        clickingOnElementFromList(driver, menuIcons, index);
        log.info("Menu button clicked for: {}", getDeleteRFPTitlesText(index));
        return this;
    }

    // TODO: Create a method to click on the delete RFP button
    public P05_MyRFPs clickDeleteRFPButton() {
        clickingOnElement(driver, deleteRFPButton);
        log.info("Delete RFP button clicked");
        return this;
    }

    // TODO: Create a method to confirm the deletion of RFP
    public void confirmDeleteRFP() {
        clickingOnElement(driver, confirmDeleteButton);
        log.info("RFP deletion confirmed");
    }

    // TODO: Create a method to check if the RFP is deleted
    public boolean isRFPPresent() throws InterruptedException {
        // Check if the RFP title is not empty
        if (driver.findElements(deleteRFPTitles).isEmpty()) {
            log.error("RFP Is Deleted");
            return false;
        }

        Thread.sleep(3000); // Wait for 3 seconds to ensure the page is refreshed

        boolean isPresent = driver.findElements(deleteRFPTitles).stream()
                .map(WebElement::getText)
                .anyMatch(title -> title.equals(deleteRFPTitle));

        log.info("RFP title: {}", deleteRFPTitle);
        return isPresent;
    }

    // TODO: Create a method to click on the In Studying checkbox
    public P05_MyRFPs clickInStudyingCheckbox() {
        clickingOnElement(driver, inStudyingCheckbox);
        log.info("In Studying checkbox clicked");
        return this;
    }

    // TODO: Create a method to get the status labels
    public String getStatusLabel(int elementOrder) {
        int index = elementOrder - 1; // Convert to zero-based index
        String statusLabel = getTextFromList(driver, statusLabels, index);
        log.info("Status label for index {}: {}", index, statusLabel);
        return statusLabel;
    }


}
