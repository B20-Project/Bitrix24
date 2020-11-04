package com.bitrix24.step_definitions;

import com.bitrix24.util.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println("Starting Automation");
        Driver.getDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        // Driver.closeDriver();
        System.out.println("::: End of test execution (*_*):::");
    }

}
