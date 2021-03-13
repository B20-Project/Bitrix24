package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumberFailedRunner.json",
        glue = "com/bitrix24/step_definitions",
        features = "@target/rerun.txt",
        publish = true
                )

public class FailedRun {

}
