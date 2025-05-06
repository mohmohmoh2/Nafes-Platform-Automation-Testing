package monafsaty;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import static DriverSettings.DriverManager.getDriver;

public class TC03_AddMonafsaToFavorite extends BaseTest {



    @Test
    public void addMonafsaToFavorite() {

        // Create an instance of the main page
        Pages.P03_Main mainPage = new Pages.P03_Main(getDriver());
        mainPage.clickMonafsaty()
                .clickToFavoriteButton();

        // Wait until the element is visible
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement favIcon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='تبديل المفضلة']"))
        );

        Assert.assertTrue(favIcon.isDisplayed(), "Favorite icon is not visible");

    }



}
