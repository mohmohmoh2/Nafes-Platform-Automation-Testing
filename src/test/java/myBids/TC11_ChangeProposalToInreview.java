package myBids;

import Pages.P03_Main;
import Pages.P06_MyBids;
import Utilities.RetryAnalyzer;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;

public class TC11_ChangeProposalToInreview extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void changeProposalToInReview() {

        // Navigate to the Bids page
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyBids();

        P06_MyBids myBidsPage = new P06_MyBids(getDriver());
        myBidsPage.clickBidMenuIcon(1).clickInReviewBidCheckbox(); // Click on the bid menu icon

        Assert.assertEquals(myBidsPage.getStatusLabelText(), "قيد التحضير");


    }
}
