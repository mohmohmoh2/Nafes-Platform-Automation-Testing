package myBids;

import Pages.P03_Main;
import Pages.P06_MyBids;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;

public class TC10_AddNewBid extends BaseTest {



    @Test
    public void addNewProposal() {
        // Navigate to the Bids page
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyBids();

        P06_MyBids myProposalsPage = new P06_MyBids(getDriver());
        myProposalsPage.clickNewButton()
                .enterSearchText("اا")  // Enter text in the search field
                .clickSearchIcon()  // Click the search icon
                .clickFirstSearchResult()  // Click the first search result
                .clickNextButton()  // Click the Next button
                .clickFirstParticipant() // Click the first participant
                .clickSaveButton();  // Click the Save button

        //   Verify that the proposal was added successfully
        Assert.assertEquals(myProposalsPage.getFirstBidTitle(), myProposalsPage.monafsaResultTitle);

    }






}
