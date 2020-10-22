package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/bitrix24/step_definitions",
        features = "src/test/resources/features/Message.feature",
        dryRun = false,
        tags = "@addContact"

)
public class ActivityStreamRunner {
}
