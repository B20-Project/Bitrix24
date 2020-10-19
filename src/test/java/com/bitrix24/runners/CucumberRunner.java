package com.bitrix24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = "src/test/resources/featurces/RightSied.feature",
                glue = "com/bitrix24/step_definitions",
                dryRun = true
                )
public class CucumberRunner {

}