package login;

import Pages.P03_Main;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverSettings.DriverManager.getDriver;
import static utilities.DataUtils.getPropertyValue;

public class TC02_Logout extends BaseTest {

    @Test
    public void testLogout() throws InterruptedException, IOException {

        // Click on the logout button
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickLogout();

        // Verify that the user is logged out
        String expectedUrl = getPropertyValue("config", "BASE_URL");
        String actualUrl = getDriver().getCurrentUrl();

        // Wait for the URL to change to the expected one
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Perform the assertion
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
