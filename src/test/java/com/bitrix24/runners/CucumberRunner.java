package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                plugin = "json:target/cucumber.json",
                features = "src/test/resources/features",
                glue = "com/bitrix24/step_definitions",
                tags = "@createTask",
                dryRun = false
                )

public class CucumberRunner {

}
