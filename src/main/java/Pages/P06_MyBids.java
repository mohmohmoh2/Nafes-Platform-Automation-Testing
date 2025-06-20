package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Utilities.Utility.*;

public class P06_MyBids {
    private final WebDriver driver;
    // Locators
    private final By newButton = By.xpath("//button[@class=\"btn addNew\"]"); // New Proposal button
    private final By searchMonafsaField = By.xpath("//div[1]/div/input"); // Search field
    private final By searchIcon = By.xpath("//div[3]/div/div[1]/div/button"); // Search icon
    private final By firstSearchResult = By.xpath("//div[1]/div[4]/div[1]"); // First search result
    private final By firstSearchResultTitle = By.xpath("//div[1]/div/div/label//h3"); // First search result title
    private final By nextButton = By.xpath("//div[@class=\"btn-wrapper \"]/button"); // Next button
    private final By firstParticipant = By.xpath("//div[1]/div/div/label"); // First participant
    private final By firstParticipantTitle = By.xpath("//div[1]/div/div/label//h3"); // First participant title
    private final By saveButton = By.xpath("//div[@class=\"back-wr\"]/button[@class=\"btn\"]"); // Save button
    private final By firstBidTitle = By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/h3"); // First bid title
    private final By bidMenuIcons = By.xpath("//div[@class=\"left-side\"]//button"); // Bid menu icon
    private final By bidTitles = By.xpath("//div[@class=\"bid-item\"]//h3"); // Bid titles
    private final By deleteBidButton = By.xpath("//div[@class=\"show dropdown\"]//a[3]"); // Delete bid button
    private final By editBidButton = By.xpath("//div[@class=\"show dropdown\"]//a[1]"); // Edit bid button
    private final By inReviewBidCheckbox = By.xpath("//div/div/div[2]/div/label"); // In Review bid checkbox
    private final By statusLabelStuding = By.xpath("//p[@class=\"status studying\"]"); // Status label
    private final By submittedcheckbox = By.xpath("//div[4]/div/label"); // Submitted bid checkbox
    private final By bidSalary = By.xpath("//input[@class=\"form-control\"]"); // Bid salary
    private final By saveSubmittedButton = By.xpath("//div[@class=\"modalBody\"]//button[@class=\"btn\"]"); // Save submitted button
    private final By statusLabelSubmited = By.xpath("//p[@class=\"status offerDone\"]"); // Status label
    public Logger log = LogManager.getLogger();
    public String monafsaResultTitle = "";
    public String firstParticipantTitleText = "";
    public String deleteBidTitleText = "";

    // TODO: Create a constructor
    public P06_MyBids(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: Create a method to click on the New Proposal button
    public P06_MyBids clickNewButton() {
        clickingOnElement(driver, newButton);
        log.info("Clicked on New Proposal button");
        return this;
    }

    // TODO: Create a method to enter text in the search field
    public P06_MyBids enterSearchText(String text) {
        enterData(driver, searchMonafsaField, text);
        log.info("Entered text in the search field: {}", text);
        return this;
    }

    // TODO: Create a method to click on the search icon
    public P06_MyBids clickSearchIcon() {
        clickingOnElement(driver, searchIcon);
        log.info("Clicked on the search icon");
        return this;
    }

    // TODO: Create a method to click on the first search result
    public P06_MyBids clickFirstSearchResult() {
        clickingOnElement(driver, firstSearchResult);
        log.info("Clicked on the first search result");
        getFirstSearchResultTitle();
        return this;
    }

    // TODO: Create a method to get the title of the first search result
    public void getFirstSearchResultTitle() {
        monafsaResultTitle = getText(driver, firstSearchResultTitle);
        log.info("First search result title:\n{}\n", monafsaResultTitle);
    }

    // TODO: Create a method to click on the Next button
    public P06_MyBids clickNextButton() {
        clickingOnElementJS(driver, nextButton);
        log.info("Clicked on the Next button");
        return this;
    }


    //  TODO: Create a method to click on the first participant
    public P06_MyBids clickFirstParticipant() {
        clickingOnElement(driver, firstParticipant);
        log.info("Clicked on the first participant");
        getFirstParticipantTitle();
        return this;
    }

    // TODO: Create a method to get the title of the first participant
    public void getFirstParticipantTitle() {
        firstParticipantTitleText = getText(driver, firstParticipantTitle);
        log.info("First participant title: \n{}\n", firstParticipantTitleText);
    }

    // TODO: Create a method to click on the Save button
    public void clickSaveButton() {
        clickingOnElementJS(driver, saveButton);
        log.info("Clicked on the Save button");
    }

    // TODO: Create a method to get the title of the first bid
    public String getFirstBidTitle() {
        String firstBidTitleText = getText(driver, firstBidTitle);
        log.info("First bid title: \n{}\n", firstBidTitleText);
        return firstBidTitleText;
    }

    // TODO: Create a method to get the title of the bid from the list
    public void getBidTitleFromList(int index) {
        String bidTitleText = getTextFromList(driver, bidTitles, index);
        deleteBidTitleText = bidTitleText;
        log.info("Bid title: \n{}\n", bidTitleText);
    }

    // TODO: Create a method to click on the bid menu icon
    public P06_MyBids clickBidMenuIcon(int index) {
        // Check if the index is valid
        if (index < 0 || index > driver.findElements(bidTitles).size()) {
            log.error("Index out of bounds: {}", index);
            return this;
        }

        index--;
        getBidTitleFromList(index);
        scrollingToElementFromList(driver, bidTitles, index);
        clickingOnElementFromList(driver, bidMenuIcons, index);
        log.info("Clicked on the bid menu icon");
        return this;
    }

    // TODO: Create a method to click on the delete bid button
    public void clickDeleteBidButton() {
        clickingOnElement(driver, deleteBidButton);
        log.info("Clicked on the delete bid button");
        refreshPage(driver);
    }

    // TODO: Create a method to check if the bid is deleted
    public boolean isBidPresent() {
        // Check if the bid title is not empty
        if (driver.findElements(bidTitles).isEmpty()) {
            log.error("Bid Is Deleted");
            return false;
        }

        boolean isPresent = driver.findElements(bidTitles).stream()
                .map(WebElement::getText)
                .anyMatch(title -> title.equals(deleteBidTitleText));

        log.info("Is the bid present? {}", isPresent);
        return isPresent;
    }

    // TODO: Create a method to click on inReview bid checkbox
    public void clickInReviewBidCheckbox() {
        clickingOnElement(driver, inReviewBidCheckbox);
        log.info("Clicked on the In Review bid checkbox");
    }

    // TODO: Create a method to get the text of the status label
    public String getStatusLabelText() {
        String statusText = getText(driver, statusLabelStuding);
        log.info("Status label text: \n{}\n", statusText);
        return statusText;
    }

    // TODO: Create a method to click on the submitted bid checkbox
    public P06_MyBids clickSubmittedBidCheckbox() {
        clickingOnElement(driver, submittedcheckbox);
        log.info("Clicked on the Submitted bid checkbox");
        return this;
    }

    // TODO: Create a method to enter bid salary
    public P06_MyBids enterBidSalary(String salary) {
        enterData(driver, bidSalary, salary);
        log.info("Entered bid salary: {}", salary);
        return this;
    }

    // TODO: Create a method to click on the save submitted button
    public void clickSaveSubmittedButton() {
        clickingOnElement(driver, saveSubmittedButton);
        log.info("Clicked on the Save submitted button");
    }

    // TODO: Create a method to assert that the locator is displayed
    public boolean isLocatorDisplayed() {
        boolean isDisplayed = driver.findElement(statusLabelSubmited).isDisplayed();
        log.info("Is the locator displayed? {}", isDisplayed);
        return isDisplayed;
    }


}
