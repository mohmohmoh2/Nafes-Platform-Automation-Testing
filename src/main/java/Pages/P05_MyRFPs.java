package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.Utility.clickingOnElement;

public class P05_MyRFPs {
    private final WebDriver driver;

    // Locators
    private final By uploadRFPButton = By.xpath("//button[@class=\"btn addKoraseh\"]");

    // TODO: Create a constructor
    public P05_MyRFPs(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: Create a method to click on the upload RFP button
    public void clickUploadRFPButton() {
        clickingOnElement(driver, uploadRFPButton);
    }







}
