package com.bitrix24.runners;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        plugin = "json:target/cucumberFailedRunner.json",
        glue = "com/bitrix24/step_definitions",
        features = "@target/rerun.txt"
                )

public class FailedRunner {

}
