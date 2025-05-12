package myProposals;

import Pages.P03_Main;
import Pages.P06_MyBids;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;

public class TC11_RemoveBid extends BaseTest {

    @Test
    public void testRemoveBid() {
        // Test case to remove a bid

        // Navigate to the Bids page
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyProposals();

        P06_MyBids myProposalsPage = new P06_MyBids(getDriver());
        myProposalsPage.clickOnBidMenuIcon(1) // Click the menu icon of the first bid
                .clickDeleteBidButton(); // Click the delete bid button

        // Confirm the deletion
        Assert.assertFalse(myProposalsPage.isBidTitlePresent());
    }
}
