package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.util.ConfigurationReader;
import com.bitrix24.util.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestBase {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        String URL = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.login("marketing");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }




}
