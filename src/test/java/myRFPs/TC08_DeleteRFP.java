package myRFPs;

import Pages.P03_Main;
import Utilities.RetryAnalyzer;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;

public class TC08_DeleteRFP extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testDeleteRFP() throws InterruptedException {
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyRFPs();


        // Create an instance of the P05_MyRFPs class
        Pages.P05_MyRFPs myRFPsPage = new Pages.P05_MyRFPs(getDriver());
        myRFPsPage.clickMenuButton(1) // Click on the menu button for the first RFP
                .clickDeleteRFPButton() // Click on the delete RFP button
                .confirmDeleteRFP(); // Confirm the deletion of the RFP

        // Verify that the RFP was removed successfully
        Assert.assertFalse(myRFPsPage.isRFPPresent());

    }
}
