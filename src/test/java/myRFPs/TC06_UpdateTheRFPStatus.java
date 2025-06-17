package myRFPs;

import Pages.P03_Main;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;

public class TC06_UpdateTheRFPStatus extends BaseTest {


    @Test
    public void updateRFPStatus() throws InterruptedException {
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyRFPs();

        // Create an instance of the P05_MyRFPs class
        Pages.P05_MyRFPs myRFPsPage = new Pages.P05_MyRFPs(getDriver());
        int elementOrder = 1; // Assuming you want to update the status of the first RFP
        myRFPsPage.clickMenuButton(elementOrder).clickInStudyingCheckbox(); // Click on the menu button for the first RFP

        Assert.assertEquals(myRFPsPage.getStatusLabel(elementOrder), "قيد الدراسة");

    }
}
