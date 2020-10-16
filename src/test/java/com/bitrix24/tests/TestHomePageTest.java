package com.bitrix24.tests;

import com.bitrix24.pages.HomePage;
import com.bitrix24.util.BrowserUtils;
import org.testng.annotations.Test;

public class TestHomePageTest extends AbstractTestBase {


    @Test(description = "click notification")
    public void click_notification(){
        HomePage homePage = new HomePage();
        homePage.notificationIcon.click();
        BrowserUtils.wait(1);
    }

    @Test(description = "click search")
    public void click_search(){
        HomePage homePage = new HomePage();
        homePage.search.click();
        BrowserUtils.wait(1);
    }

    @Test(description = "click listOfCurrentContacted")
    public void click_listOfCurrentContacted(){
        HomePage homePage = new HomePage();
        homePage.listOfCurrentContacted.click();
        BrowserUtils.wait(1);
    }

    @Test(description = "click notification")
    public void click_bottomBlock(){
        HomePage homePage = new HomePage();
        homePage.bottomBlock.click();
        BrowserUtils.wait(1);
    }
}
