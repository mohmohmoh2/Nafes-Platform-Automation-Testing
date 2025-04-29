package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class P01_Home {

    private final WebDriver driver;

    // Locators
    private final By loginPageButton = By.xpath("//div[2]/a[2]");

    // TODO: Create a constructor
    public P01_Home(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: Go to the login page
    public void goToLoginPage() {
        Utility.clickingOnElement(driver, loginPageButton);
    }
}
