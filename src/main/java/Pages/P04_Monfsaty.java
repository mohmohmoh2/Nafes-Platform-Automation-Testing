package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.Utility.clickingOnElement;
import static utilities.Utility.getText;

public class P04_Monfsaty {
    private final WebDriver driver;
    public Logger log = LogManager.getLogger();
    public String monafsaTitle = "";

    // Locators
    private final By monafsatyButton = By.xpath("//a[@href='/account/my-tenders']");
    private final By monasfatyDropdown = By.xpath("//a[@class=\"has-sub active\"]");
    private final By toFavoriteButton = By.xpath("//button[@class=\"add-to-fav action-icon \"]");
    private final By suitableMonafsatButton = By.xpath("//a[@href='/account/my-tenders/favorites']");
    private final By removeFromFavoriteButton = By.xpath("//button[@class='add-to-fav fav-icon ']");
    public final By monafsaTitleLocator = By.xpath("//div[2]/div[2]/h1");
    private final By okButton = By.xpath("//button[@class=\"exit-btn continue\"]");

    // TODO: Create a constructor
    public P04_Monfsaty(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Click on Monafsaty
    public P04_Monfsaty clickMonafsaty() {
        log.info("Clicking on Monafsaty button");
        clickingOnElement(driver, monafsatyButton);
        return this;
    }

    //TODO: Click on toFavoriteButton
    public void clickToFavoriteButton() {
        log.info("Add to Favorite For Monafsa: {}", getText(driver, monafsaTitleLocator));
        clickingOnElement(driver, toFavoriteButton);
    }

    //TODO: Click on Monafsaty Dropdown
    public P04_Monfsaty clickMonasfatyDropdown() {
        log.info("Clicking on Monasfaty Dropdown");
        clickingOnElement(driver, monasfatyDropdown);
        return this;
    }

    //TODO: Click on suitableMonafsatButton
    public P04_Monfsaty clickSuitableMonafsatButton() {
        log.info("Clicking on Right Sign For Sutable Monafsat");
        clickingOnElement(driver, suitableMonafsatButton);
        return this;
    }

    //TODO: Get Monafsa Title
    public String getMonafsaTitle() {
        return getText(driver, monafsaTitleLocator);
    }

    //TODO: Get Monafsa Title
    public void setMonafsaTitle() {
        this.monafsaTitle = getMonafsaTitle();
    }

    //TODO: Click on removeFromFavoriteButton
    public P04_Monfsaty clickRemoveFromFavoriteButton() {
        setMonafsaTitle();
        log.info("Remove From Favorite For Monafsa: {}", monafsaTitle);
        clickingOnElement(driver, removeFromFavoriteButton);
        return this;
    }

    //TODO: Click on okButton
    public void clickOkButton() {
        log.info("Clicking on Ok button from the popup");
        clickingOnElement(driver, okButton);
    }

}
