package com.bitrix24.tests;

import com.bitrix24.pages.HomePage;
import org.testng.annotations.Test;

public class TestHomePageTest extends AbstractTestBase {
    HomePage homePage;

    @Test(description = "click notification")
    public void click_notification(){
        homePage.notificationIcon.click();
    }

    @Test(description = "click search")
    public void click_search(){
        homePage.search.click();
    }

    @Test(description = "click listOfCurrentContacted")
    public void click_listOfCurrentContacted(){
        homePage.listOfCurrentContacted.click();
    }

    @Test(description = "click notification")
    public void click_bottomBlock(){
        homePage.bottomBlock.click();
    }
}
