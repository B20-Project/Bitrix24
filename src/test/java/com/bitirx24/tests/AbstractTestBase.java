package com.bitirx24.tests;

import com.bitirx24.util.ConfigurationReader;
import com.bitirx24.util.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestBase {

//    HomePage homepage;

    @BeforeMethod
    public void setUp() {
        String URL = ConfigurationReader.getProperty("phptravelsUrl");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        homepage = new HomePage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }




}
