package monafsaty;

import Utilities.RetryAnalyzer;
import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverSettings.DriverManager.getDriver;

public class TC04_RemoveMonafsaFromFavorite extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void removeMonafsaFromFavorite() {
        // Create an instance of the main page
        Pages.P04_Monfsaty Monfsaty = new Pages.P04_Monfsaty(getDriver());
        Monfsaty.clickMonafsaty()
                .clickMonasfatyDropdown()
                .clickSuitableMonafsatButton()
                .clickRemoveFromFavoriteButton()
                .clickOkButton();

        // Wait until the element is visible
        new WebDriverWait(getDriver(), Duration.ofSeconds(20))
                .until(driver -> driver.findElement(Monfsaty.monafsaTitleLocator).isDisplayed());

        // Verify that the monafsa is removed from favorites
        Assert.assertNotEquals(Monfsaty.getMonafsaTitle(), Monfsaty.monafsaTitle);

    }
}
