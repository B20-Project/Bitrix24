package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.util.ConfigurationReader;
import com.bitrix24.util.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestBase {
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        String URL = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.login("marketing");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }




}
