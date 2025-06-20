package myRFPs;

import Pages.P03_Main;
import Pages.P05_MyRFPs;
import Utilities.RetryAnalyzer;
import base.BaseTest;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;

public class TC05_UploadRFP extends BaseTest {


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testUploadRFP() {
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyRFPs();

        // Create an instance of the P05_MyRFPs class
        P05_MyRFPs myRFPsPage = new P05_MyRFPs(getDriver());
        myRFPsPage.clickUploadRFPButton()
                .clickSearchForMonafsaButton()
                .enterMonafsaSearchInput("ا")
                .clickMonafsaSearchButton()
                .uploadRFPFile("src\\test\\resources\\tender.pdf")
                .waitForFileUpload();

    }


}
