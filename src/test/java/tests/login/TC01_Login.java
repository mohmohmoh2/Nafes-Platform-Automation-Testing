package tests.login;

import DriverSettings.DriverManager;
import Pages.P01_Home;
import Pages.P02_Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverSettings.DriverManager.*;
import static utilities.DataUtils.getJsonData;
import static utilities.DataUtils.getPropertyValue;

public class TC01_Login {
    private static final String EXPECTED_URL;

    static {
        try {
            EXPECTED_URL = getPropertyValue("config", "BASE_URL");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setUp() throws IOException {
        String driverType = getPropertyValue("config", "driverType");
        WebDriver driver = DriverManager.createDriver(driverType);
        setDriver(driver);
        getDriver().get(getPropertyValue("config", "BASE_URL"));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testLogin() throws IOException {
        // Navigate to the login page
        P01_Home homePage = new P01_Home(getDriver());
        homePage.goToLoginPage();

        // Perform login
        P02_Login loginPage = new P02_Login(getDriver());
        loginPage.enterUsername(getJsonData("login", "email"))
                .enterPassword(getJsonData("login", "password"))
                .clickLogin();

        // Wait for the URL to change to the expected one
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(getPropertyValue("config", "ACCOUNT_URL")));


        // Perform the assertion
        Assert.assertEquals(getDriver().getCurrentUrl(), getPropertyValue("config", "ACCOUNT_URL"));


    }

    @AfterMethod
    public void tearDown() {
        // TODO: Close the browser
        quitDriver();
    }
}
