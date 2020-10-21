package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/bitrix24/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = true,
        tags = "@uploadFromLocal"

)
public class ActivityStreamRunner {
}
