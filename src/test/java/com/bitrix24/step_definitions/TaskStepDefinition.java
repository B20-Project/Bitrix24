package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.util.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskStepDefinition {
    ActivityStreamPage activityStream = new ActivityStreamPage();


    @Given("user enters title on {string} input box and enters {string}")
    public void user_enters_title_on_input_box(String string, String string2) {
        activityStream.enterFeedTitle(string, string2);
    }
    @And("user enters description {string}")
    public void user_enters_description(String text) {
        activityStream.enterDescription(text);
    }

    @Given("user selects  responsible person {string} from {string}")
    public void user_selects_responsible_person_from(String name, String tab) {
        activityStream.clickCancelSelectionBtn("Responsible person");
        BrowserUtils.wait(1);
        activityStream.clickFinderBoxTabSelection(tab);
        BrowserUtils.wait(1);
        activityStream.clickEmployeeName(name);
        activityStream.closePopUpWindow();
    }

    @When("user clicks on task additional block {string}")
    public void user_clicks_on_task_additional_block(String string) {
        activityStream.clickTaskAdditionalBlock(string);
    }

    @And("user selects {string} from {string}")
    public void user_selects_from(String name, String tab) {
        BrowserUtils.wait(1);
        activityStream.clickFinderBoxTabSelection(tab);
        BrowserUtils.wait(1);
        activityStream.clickEmployeeName(name);
        activityStream.closePopUpWindow();
    }

    @When("user clicks on {string} button in {string} block")
    public void user_clicks_on_button_in_block(String block, String string2) {
        activityStream.clickAddBtn(string2,block);
        BrowserUtils.wait(1);
    }

    @Then("{string} message should display in pop-up window")
    public void message_should_display_in_pop_up_window(String string) {
        Assert.assertEquals(activityStream.getTextFromCreatedTaskConfirmationMessage(), string);

    }






}
