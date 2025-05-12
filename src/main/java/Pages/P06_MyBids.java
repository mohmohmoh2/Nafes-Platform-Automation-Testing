package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.Utility.*;

public class P06_MyProposals {
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


    public String monafsaResultTitle = "";
    public String firstParticipantTitleText = "";

    // TODO: Create a constructor
    public P06_MyProposals(WebDriver driver) {this.driver = driver;}

    // TODO: Create a method to click on the New Proposal button
    public P06_MyProposals clickNewButton() {
        clickingOnElement(driver, newButton);
        log.info("Clicked on New Proposal button");
        return this;
    }

    // TODO: Create a method to enter text in the search field
    public P06_MyProposals enterSearchText(String text) {
        enterData(driver, searchMonafsaField, text);
        log.info("Entered text in the search field: {}", text);
        return this;
    }

    // TODO: Create a method to click on the search icon
    public P06_MyProposals clickSearchIcon() {
        clickingOnElement(driver, searchIcon);
        log.info("Clicked on the search icon");
        return this;
    }

    // TODO: Create a method to click on the first search result
    public P06_MyProposals clickFirstSearchResult() {
        clickingOnElement(driver, firstSearchResult);
        log.info("Clicked on the first search result");
        getFirstSearchResultTitle();
        return this;
    }

    // TODO: Create a method to get the title of the first search result
    public void getFirstSearchResultTitle() {
        monafsaResultTitle = getText(driver, firstSearchResultTitle);
        log.info("First search result title:\n" + monafsaResultTitle + "\n");
    }

    // TODO: Create a method to click on the Next button
    public P06_MyProposals clickNextButton() {
        clickingOnElementJS(driver, nextButton);
        log.info("Clicked on the Next button");
        return this;
    }


    //  TODO: Create a method to click on the first participant
    public P06_MyProposals clickFirstParticipant() {
        clickingOnElement(driver, firstParticipant);
        log.info("Clicked on the first participant");
        getFirstParticipantTitle();
        return this;
    }

    // TODO: Create a method to get the title of the first participant
    public void getFirstParticipantTitle() {
        firstParticipantTitleText = getText(driver, firstParticipantTitle);
        log.info("First participant title: \n" + firstParticipantTitleText + "\n");
    }

    // TODO: Create a method to click on the Save button
    public P06_MyProposals clickSaveButton() {
        clickingOnElementJS(driver, saveButton);
        log.info("Clicked on the Save button");
        return this;
    }

    // TODO: Create a method to get the title of the first bid
    public String getFirstBidTitle() {
        String firstBidTitleText = getText(driver, firstBidTitle);
        log.info("First bid title: \n{}\n", firstBidTitleText);
        return firstBidTitleText;
    }


}
