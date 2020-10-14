package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.util.BrowserUtils;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestBase {

    LoginPage login = new LoginPage();

    @Test
    public void test1(){
        login.login("marketing");
        BrowserUtils.wait(3);
        login.click_header("search");
        BrowserUtils.wait(3);
    }
}
