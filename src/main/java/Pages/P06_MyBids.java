package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static utilities.Utility.*;

public class P06_MyBids {
    private final WebDriver driver;
    public Logger log = LogManager.getLogger();

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
    private final By bidMenuIcons = By.xpath("//div[@class=\"left-side\"]//button"); // Bid menu icons
    private final By bidTitles = By.xpath("//div[@class=\"bid-item\"]//h3"); // Bid titles
    private final By editBidButton = By.xpath("//div[@class=\"show dropdown\"]//a[1]"); // Edit bid button
    private final By deleteBidButton = By.xpath("//div[@class=\"show dropdown\"]//a[3]"); // Delete bid button





    public String monafsaResultTitle = "";
    public String firstParticipantTitleText = "";
    public String deleteBidTitle = "";

    // TODO: Create a constructor
    public P06_MyBids(WebDriver driver) {this.driver = driver;}

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

    // TODO: Create a method to get the title of the bid
    public void getBidTitle(int index) {
        String bidTitleText = getTextFromList(driver, bidTitles, index);
        deleteBidTitle = bidTitleText;
        log.info("Delete Bid title: \n{}\n", bidTitleText);
    }

    // TODO: Create a method to click on the bid first menu icon
    public P06_MyBids clickOnBidMenuIcon(int index) {

        //Check if the list of bid menu icons is not empty
        if (driver.findElements(bidMenuIcons).isEmpty()) {
            log.error("No bid menu icons found");
            return this;
        }
        index--;
        // Scroll to the bid menu icon
        scrolling(driver, bidMenuIcons, index);
        // Get the title of the bid before clicking on the menu icon
        getBidTitle(index);

        // Click on the bid menu icon
        clickingOnElementFromList(driver, bidMenuIcons, index);
        log.info("Clicked on the first bid menu icon");
        return this;
    }

    // TODO: Create a method to click on the delete bid button
    public void clickDeleteBidButton() {
        clickingOnElement(driver, deleteBidButton);
        log.info("Clicked on the delete bid button");
    }

    // TODO: Create a method to assert the bid title
    public boolean isBidTitlePresent(){
        refreshPage(driver);

        if (driver.findElements(bidTitles).isEmpty()) {
            return false;
        }

        // Check if the delete bid title is present in the list of bid titles
        boolean isPresent = driver.findElements(bidTitles).stream()
                .anyMatch(element -> element.getText().equals(deleteBidTitle));
        log.info("Is bid title present: {}", isPresent);
        return isPresent;
    }


}
