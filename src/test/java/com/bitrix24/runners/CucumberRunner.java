package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = "src/test/resources/features",
                glue = "com/bitrix24/step_definitions",
                tags = "@taskArpatAC6",
                dryRun = false
                )

public class CucumberRunner {

}
