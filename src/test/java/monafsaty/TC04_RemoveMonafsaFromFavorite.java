package monafsaty;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverSettings.DriverManager.getDriver;

public class TC04_RemoveMonafsaFromFavorite extends BaseTest {

    @Test
    public void removeMonafsaFromFavorite() {
        // Create an instance of the main page
        Pages.P03_Main mainPage = new Pages.P03_Main(getDriver());
        mainPage.clickMonafsaty()
                .clickMonasfatyDropdown()
                .clickSuitableMonafsatButton()
                .clickRemoveFromFavoriteButton()
                .clickOkButton();

        // Wait until the element is visible
        new WebDriverWait(getDriver(), Duration.ofSeconds(20))
                .until(driver -> driver.findElement(mainPage.monafsaTitleLocator).isDisplayed());

        // Verify that the monafsa is removed from favorites
        Assert.assertNotEquals(mainPage.getMonafsaTitle(), mainPage.monafsaTitle);

    }
}
