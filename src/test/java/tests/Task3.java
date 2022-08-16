package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePageMicrosoft;
import pageObjects.HomePageFacebook;

public class Task3 extends TestInit {

    @Test(groups = "UI")
    public void tabSwitcher() {
        HomePageMicrosoft homePageMicrosoft = new HomePageMicrosoft(driver);
        HomePageFacebook homePageFacebook = new HomePageFacebook(driver);

        openUrl("https://www.microsoft.com/"); //go to Microsoft website
        Assert.assertTrue(homePageMicrosoft.getMicrosoftLogo().isDisplayed()); //assert that page is correctly displayed
        homePageMicrosoft.clickFacebookBtn(); //click Facebook btn to open new tab
        switchTabs(getTabs().get(1)); //switch tab to Facebook
        Assert.assertTrue(homePageFacebook.getAccountName().isDisplayed()); //assert that page is correctly displayed
    }
}
