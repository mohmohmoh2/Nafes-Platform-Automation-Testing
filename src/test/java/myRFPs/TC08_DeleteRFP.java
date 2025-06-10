package myRFPs;

import Pages.P03_Main;
import base.BaseTest;
import org.testng.annotations.Test;

import static DriverSettings.DriverManager.getDriver;

public class TC08_DeleteRFP extends BaseTest {

    @Test
    public void testDeleteRFP() {
        P03_Main mainPage = new P03_Main(getDriver());
        mainPage.clickMyRFPs();


        // Create an instance of the P05_MyRFPs class
        Pages.P05_MyRFPs myRFPsPage = new Pages.P05_MyRFPs(getDriver());


    }
}
