package myBids;

import Pages.P03_Main;
import Pages.P06_MyBids;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;

public class TC11_RemoveBid extends BaseTest {

    @Test
    public void removeBid() {
        // Navigate to the Bids page
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyBids();

        P06_MyBids myBidsPage = new P06_MyBids(getDriver());
        myBidsPage.clickBidMenuIcon(1).clickDeleteBidButton(); // Click on the bid menu icon

        // Verify that the bid was removed successfully
        Assert.assertFalse(myBidsPage.isBidPresent());
    }
}
