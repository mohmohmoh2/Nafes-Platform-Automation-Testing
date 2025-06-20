package login;

import Pages.P03_Main;
import Utilities.RetryAnalyzer;
import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverSettings.DriverManager.getDriver;
import static Utilities.DataUtils.getPropertyValue;

public class TC02_Logout extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLogout() throws InterruptedException, IOException {

        // Click on the logout button
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickLogout();

        String expectedUrl = getPropertyValue("config", "BASE_URL");
        // Wait for the URL to change to the expected one
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Verify that the user is logged out
        String actualUrl = getDriver().getCurrentUrl();

        // Perform the assertion
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
