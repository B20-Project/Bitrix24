package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = "src/test/resources/features",
                glue = "com/bitrix24/step_definitions",
                tags = "@AC1",
                dryRun = true

                )
public class CucumberRunner {

}
