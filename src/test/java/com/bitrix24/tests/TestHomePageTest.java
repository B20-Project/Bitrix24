package com.bitrix24.tests;

import com.bitrix24.pages.HomePage;
import com.bitrix24.util.BrowserUtils;
import com.bitrix24.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePageTest extends AbstractTestBase {

    @Test(description = "click notification")
    public void verify_notification(){
        HomePage homePage = new HomePage();
        homePage.notificationIcon.click();
        BrowserUtils.wait(1);

        Assert.assertTrue(homePage.sideWindowPopUp.isDisplayed());
    }

    @Test(description = "click search")
    public void verify_search(){
        HomePage homePage = new HomePage();
        homePage.search.click();
        BrowserUtils.wait(1);

        Assert.assertTrue(homePage.sideWindowPopUp.isDisplayed());

    }

    @Test(description = "click listOfCurrentContacted")
    public void verify_listOfCurrentContacted(){
        HomePage homePage = new HomePage();
        homePage.listOfCurrentContacted.click();
        BrowserUtils.wait(1);

        Assert.assertTrue(homePage.sideWindowPopUp.isDisplayed());
    }

    @Test(description = "click bottomBlock and is not display")
    public void verify_bottomBlock(){
        HomePage homePage = new HomePage();
        homePage.bottomBlock.click();

        Assert.assertFalse(homePage.sideWindowPopUp.isDisplayed());
    }

    @Test
    public void verify_sidePopUpWindow_contact_you(){
        HomePage homePage= new HomePage();
        homePage.click_sidePopUpWindow_contact_you();
        BrowserUtils.wait(1);

        Assert.assertTrue(homePage.sidePopUpWindow_Verify_dialogMessenger.isDisplayed());
    }

    @Test
    public void verify_sidePopUpWindow_message() {
        HomePage homePage = new HomePage();
        homePage.click_sidePopUpWindow_message();
        BrowserUtils.wait(1);

        Assert.assertTrue(homePage.sidePopUpWindow_Verify_dialogMessenger.isDisplayed());
    }

    @Test
    public void verify_click_sidePopUpWindow_clones() {
        HomePage homePage = new HomePage();
        homePage.click_sidePopUpWindow_clones();
        BrowserUtils.wait(1);

        Assert.assertFalse(homePage.sideWindowPopUp.isDisplayed());
    }

    @Test
    public void verify_sidePopUpWindow_notifications() {
        HomePage homePage = new HomePage();
        homePage.click_sidePopUpWindow_notifications();
        BrowserUtils.wait(1);

        Assert.assertTrue(homePage.sidePopUpWindow_Verify_dialogNotifications.isDisplayed());
    }

    @Test
    public void verify_sidePopUpWindow_setting() {
        HomePage homePage = new HomePage();
        homePage.click_sidePopUpWindow_setting();
        BrowserUtils.wait(1);

        Assert.assertTrue(homePage.sidePopUpWindow_Verify_popupSettings.isDisplayed());

    }

}
