package com.bitrix24.step_definitions;

import com.bitrix24.util.BrowserUtils;
import com.bitrix24.util.ConfigurationReader;
import com.bitrix24.util.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println("Starting Automation");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //delete the wait time here
    @After
    public void tearDown(){
        BrowserUtils.wait(3);
        Driver.closeDriver();
        System.out.println("::: End of test execution (*_*):::");
    }


}
