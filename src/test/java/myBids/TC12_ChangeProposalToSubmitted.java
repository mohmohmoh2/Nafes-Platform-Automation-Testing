package myBids;

import Pages.P03_Main;
import Pages.P06_MyBids;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;
import static Utilities.Utility.generateRandomNumber;

public class TC12_ChangeProposalToSubmitted extends BaseTest {

    @Test
    public void changeProposalToSubmitted() {

        // Navigate to the Bids page
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyBids();

        P06_MyBids myBidsPage = new P06_MyBids(getDriver());
        myBidsPage.clickBidMenuIcon(1) // Click on the bid menu icon for the first bid
                .clickSubmittedBidCheckbox() // Click on the "Submitted" checkbox
                .enterBidSalary(String.valueOf(generateRandomNumber(100))) // Enter a random bid salary
                .clickSaveSubmittedButton(); // Click on the bid menu icon

        // Assert that the locator is displayed
        Assert.assertTrue(myBidsPage.isLocatorDisplayed(), "The bid is not present");
    }
}
