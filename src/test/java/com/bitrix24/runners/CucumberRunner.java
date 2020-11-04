package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                plugin = "json:target/cucumber.json",
                features = "src/test/resources/features",
                glue = "com/bitrix24/step_definitions",
                tags = "@calendar",
                dryRun = false
                )

public class CucumberRunner {

}
