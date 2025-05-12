package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utilities.Utility.*;

public class P03_Main {
    // Locators
    private final By loginPageButton = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[1]/div[2]/ul/div[3]/li[2]/a");


    private final WebDriver driver;
    public Logger log = LogManager.getLogger();

    public String monafsaTitle = "";

    // TODO: Create a constructor
    public P03_Main(WebDriver driver) {
        this.driver = driver;
    }


    // TODO: Click Logout
    public void clickLogout() {
        log.info("Clicking on Logout button");
        clickingOnElement(driver, loginPageButton);
    }







}
